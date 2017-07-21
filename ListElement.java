import java.util.*;
public class ListElement{
	public static void main(String args[]){
		String s1[] = {"eggs","lasers","hats","pie"};
		List<String> list1 = new ArrayList<String>();
		
		for(String x : s1){
			list1.add(x);
		}
		
		String s2[] ={"lasers", "hats"};
		List<String> list2 = new ArrayList<String>();
		
		for(String y : s2){
			list2.add(y);
		}
		for(int i = 0; i < list1.size() ; i++){
			System.out.printf("%s " , list1.get(i));
		}
		editList(list1,list2);
		System.out.println();
		
		for(int i = 0; i < list1.size() ; i++){
			System.out.printf("%s " , list1.get(i));
		}
	}

	public static void editList(List<String> list1, List<String> list2) {
		for(int i=0 ; i < list2.size() ; i++){
			if(list1.contains(list2.get(i))){
				list1.remove(i);
			}
		}
		
	}
}