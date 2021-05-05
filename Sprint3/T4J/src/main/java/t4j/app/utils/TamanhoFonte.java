package t4j.app.utils;

public enum TamanhoFonte {
    PEQUENO,
    MEDIO,
    GRANDE;

    public static String getCssPath(TamanhoFonte tamanhoFonte){
        switch (tamanhoFonte) {
            case MEDIO:
                return "/css/fontMedium.css";
            case GRANDE:
                return "/css/fontBig.css";
            case PEQUENO:
                return "/css/fontSmall.css";
            default:
                return null;
        }
    }
}
