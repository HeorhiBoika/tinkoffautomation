package utils;

public class Data {
    private static final String PATH_TMPL = "src/test/resources/testdata/%s";
    private String path;

    public Data() {}

    public Data(String fileName) {
        this.path = String .format(PATH_TMPL, fileName);
    }

    public String getPath() {
        return path;
    }
}
