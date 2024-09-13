package com.javalent.curio.features.items.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javalent.curio.features.items.models.Item;
import com.javalent.curio.features.items.models.ItemSearchDTO;
import com.javalent.curio.features.items.repository.ItemRepository;
import com.javalent.curio.search.models.FieldSearchPredicate;
import com.javalent.curio.search.models.SearchPredicate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
    private static final Logger LOGGER = Logger.getLogger(ItemService.class);

    private final ItemRepository itemRepository;

    public Iterable<Item> getAll() {
        return itemRepository.findAll(Sort.by("title"));
    }

    public Iterable<Item> getAll(ItemSearchDTO params) {
        return getAll(params, Pageable.ofSize(100));
    }

    public Page<Item> getAll(ItemSearchDTO params, Pageable page) {
        LOGGER.info(params);

        if (params.getQuery() != null) {
            return search(params, page);
        } else if (!params.getTags().isEmpty() && !params.getMuseums().isEmpty()) {
            return itemRepository.findByTagsInAndMuseum_NameIn(params.getTags(), params.getMuseums(),
                    page);
        }
        if (!params.getTags().isEmpty()) {
            return itemRepository.findByTagsIn(params.getTags(), page);
        }
        if (!params.getMuseums().isEmpty()) {
            return itemRepository.findByMuseum_NameIn(params.getMuseums(), page);
        }

        return itemRepository.findAll(page);
    }

    public Optional<Item> getOne(String item) {
        return itemRepository.findById(item);
    }

    static List<SearchPredicate> PREDICATES = Arrays.asList(
            FieldSearchPredicate.builder().field("title").boost(1000).build(),
            FieldSearchPredicate.builder().field("title").boost(750).fuzzy(1).build(),
            FieldSearchPredicate.builder().field("summary").field("physicalDescription").field("longDescription")
                    .boost(100)
                    .fuzzy(1).build());

    public List<Item> search(String query) {
        var search = new ItemSearchDTO();
        search.setQuery(query);
        return itemRepository.searchBy(PREDICATES, search, 100);
    }

    public Page<Item> search(ItemSearchDTO params, Pageable page) {

        List<Item> allList = itemRepository.searchBy(PREDICATES, params, page.getPageSize());
        List<Item> pageList = allList.stream()
                .skip(page.getOffset())
                .limit(page.getPageSize())
                .collect(Collectors.toList());

        return new PageImpl<>(pageList, page, allList.size());

    }

    public void delete() {
        itemRepository.deleteAll();
    }

}
