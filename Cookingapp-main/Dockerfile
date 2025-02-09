# Use official Node.js image for building the Angular app
FROM node:18 AS build-stage

WORKDIR /app

# Copy package.json and package-lock.json first to leverage Docker caching
COPY package*.json ./
RUN npm install
RUN npm install -g @angular/cli

# Copy the entire project and build it
COPY . . 

# Use npx to run Angular CLI without global install
RUN npx ng build --configuration=production

# Start a new container with Nginx to serve the built Angular app
FROM nginx:alpine
COPY --from=build-stage /app/dist/mycookapp /usr/share/nginx/html

# Expose the port
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

