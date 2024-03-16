package personagem;

public enum UniversoEnum {

    MARVEL, DC, OUTROS;

    public static UniversoEnum getUniverso(String universo) {
        if (universo.equalsIgnoreCase("marvel")) {
            return MARVEL;
        } else if (universo.equalsIgnoreCase("dc")) {
            return DC;
        } else {
            return OUTROS;
        }
    }

}
