package data;

/**
 * Enum - stores names of countries, alfa2 code and existence in the country list
 *
 * @author Eduard Zaretski
 */

public enum Countries {

    DE("Germany", "DE", true),
    GB("United Kingdom of Great Britain and Northern Ireland", "GB", true),
    US("United States of America", "US", true),
    NONEXIST("SuperMegaLand", "SMLAND", false);

    private final String name;
    private final String alfa;
    private final Boolean isExist;

    /**
     * @param  name - country name
     * @param  alfa - alfa2 code
     * @param isExist - existance in the list of countries
     */
    Countries(String name, String alfa, Boolean isExist) {
        this.name = name;
        this.alfa = alfa;
        this.isExist = isExist;
    }

    public String getName() {
        return name;
    }

    public String getAlfa() {
        return alfa;
    }

    public Boolean getIsExist() {
        return isExist;
    }
}
