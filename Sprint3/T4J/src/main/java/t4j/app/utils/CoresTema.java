package t4j.app.utils;

public enum CoresTema {
    DEFAULT,
    CLARO,
    ESCURO;
    
    public static String getCssPath(CoresTema coresTema){
        switch (coresTema) {
            case CLARO:
                return "/css/themeLight.css";
            case DEFAULT:
                return "/css/themeDefault.css";
            case ESCURO:
                return "/css/themeDark.css";
            default:
                return null;
        }
    }
}
