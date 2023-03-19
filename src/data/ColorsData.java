package data;

public enum ColorsData {
    WHITE ("Белый"),
    BLACK ("Черный"),
    FOXY ("Рыжий");

    private String colorName;

    ColorsData(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
