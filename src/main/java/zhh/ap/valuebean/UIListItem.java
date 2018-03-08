package zhh.ap.valuebean;

public class UIListItem {
    private String name;
    private String content;

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

    public UIListItem(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public UIListItem() {
    }
}
