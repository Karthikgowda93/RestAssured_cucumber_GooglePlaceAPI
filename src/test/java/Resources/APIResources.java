package Resources;

// enum is just the collection of constants and methods
public enum APIResources {

    AddPlaceAPI("/maps/api/place/add/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    UpdatePlaceAPI("/maps/api/place/update/json"),
    DeletePlaceAPI("/maps/api/place/delete/json");
    private String resource;

    APIResources(String resource) {

        this.resource=resource;
    }

    public String getResource(){
        return resource;
    }

}
