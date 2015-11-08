
public class RunLab4 {

	public static void main(String[] args) {
		List list = new LinkedList();
		
		list.add("A");
		list.add("way");
		list.add("with");
		list.add("words");
		
		Object[] words = list.toArray();
		
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}

	}

}
