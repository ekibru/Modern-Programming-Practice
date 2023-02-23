package mid_term_practice;

import java.util.*;

public class Admin {
	//Returns phone numbers (in sorted order) of the Library Members who have ever checked out the specified lending item
	public static List<String> getPhoneNums(LibraryMember[] members, LendingItem item) {
		List<String> phoneNums = new ArrayList<>();
		for(LibraryMember m: members)
		{
			for(CheckoutRecordEntry i : m.getCheckoutRecord().getCheckoutRecordEntryList())
			{
				if(i.getLendingItem().equals(item))
					phoneNums.add(m.getPhone());
			}
		}
		Collections.sort(phoneNums);
		return phoneNums;
	}
}
