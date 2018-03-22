package fourloops.scavenger;

/**
 * Created by Tyler on 3/20/2018.
 */

public class ListItem {
    private String itemTitle;
    private String itemBody;


    public ListItem(String itemTitle, String itemBody) {
        this.itemTitle = itemTitle;
        this.itemBody = itemBody;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemBody() {
        return itemBody;
    }

    public void setItemBody(String itemBody) {
        this.itemBody = itemBody;
    }
}
