FROM node:latest AS build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

RUN ls -ltr

FROM nginx:latest
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /app/dist /usr/share/nginx/html

LABEL org.opencontainers.image.source=https://github.com/valentine195/curio