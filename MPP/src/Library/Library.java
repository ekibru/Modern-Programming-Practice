package Library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<IItemCopy> itemCopies;
    private List<IMember> members;

    public Library(String name) {
        this.name = name;
        itemCopies = new ArrayList<>();
        members = new ArrayList<>();
    }

    public  void addItemCopy(IItemCopy itemCopy)
    {
        this.itemCopies.add(itemCopy);
    }



    public void addMember(IMember member)
    {
        this.members.add(member);
    }
}
