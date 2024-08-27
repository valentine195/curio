package com.javalent.curio.connectors.smithstonian;

public enum SubUnits {
    AAA,
    ACM,
    CFCHFOLKLIFE,
    CHNDM,
    EEPA,
    FBR,
    FSG,
    HAC,
    HMSG,
    HSFA,
    NAA,
    NASM,
    NMAAHC,
    NMAH,
    NMAI,
    NMAfA,
    NMNH,
    NMNHANTHRO,
    NMNHBIRDS,
    NMNHBOTANY,
    NMNHEDUCATION,
    NMNHENTO,
    NMNHFISHES,
    NMNHHERPS,
    NMNHINV,
    NMNHMAMMALS,
    NMNHMINSCI,
    NMNHPALEO,
    NPG,
    NPM,
    NZP,
    SAAM,
    SIA,
    SIL;

    private String BASE_URL = "https://smithsonian-open-access.s3-us-west-2.amazonaws.com/metadata/edan";

    public String getURL() {
        return BASE_URL + this.name().toLowerCase() + "/index.txt";
    }
}
