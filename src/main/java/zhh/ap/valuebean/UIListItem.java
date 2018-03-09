package zhh.ap.valuebean;

public class UIListItem {
    private String name;
    private String content;
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "UIListItem{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public UIListItem(String name, String content, String key) {
        this.name = name;
        this.content = content;
        this.key = key;
    }

    public UIListItem() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
