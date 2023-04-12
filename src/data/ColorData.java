package data;

public enum ColorData {
    WHITE ("белый"),
    BLACK ("черный"),
    FOXY ("рыжий");

    private String colorName;

    ColorData(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return this.colorName;
    }
}