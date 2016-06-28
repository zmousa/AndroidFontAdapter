package zenus.com.androidfontadapter.util;

public enum FontEnum {
    AR_ALDAHABI("AR_ALDAHABI"),
    AR_ANDALUS("AR_ANDALUS"),
    AR_TYPE_SETTINGS("AR_TYPE_SETTINGS"),
    AR_KUFI("AR_KUFI"),
    AR_NASKH("AR_NASKH"),
    AR_SAN("AR_SAN"),
    AR_SIMPLIFIED("AR_SIMPLIFIED"),
    AR_TRADITIONAL("AR_TRADITIONAL"),

    EN_ARIAL("EN_ARIAL"),
    EN_CALIBRI("EN_CALIBRI"),
    EN_CAMBRIA("EN_CAMBRIA"),
    EN_COMIC("EN_COMIC"),
    EN_IMPACT("EN_IMPACT"),
    EN_TAHOMA("EN_TAHOMA"),
    EN_TIMES("EN_TIMES"),
    EN_VERDANA("EN_VERDANA");

    private String value;
    FontEnum(String value){
            this.value = value;
        }
}
