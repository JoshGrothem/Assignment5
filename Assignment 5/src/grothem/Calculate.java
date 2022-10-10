package grothem;

public class Calculate {

	public static Node push(Node head_ref, int new_data) {
		Node new_node = new Node();
		new_node.data = new_data;
		new_node.next = (head_ref);
		(head_ref) = new_node;
		return head_ref;
	}

	public static double avgOfNodes(Node head) {
		if (head == null)
			return -1;

		int count = 0;
		int sum = 0;
		double avg = 0.0;

		Node current = head;
		while (current != null) {
			count++;
			sum += current.data;
			current = current.next;
		}

		avg = (double) sum / (count - 1);

		return avg;
	}

	public static double stdOfNodes(Node head, double mean) {
		double std = 0.0;
		double res = 0.0;
		double sq = 0.0;
		int count = 0;
		if (head == null)
			return -1;

		Node current = head;
		while (current != null) {
			std = std + Math.pow((current.data - mean), 2);
			current = current.next;
			count++;
		}

		sq = std / count;
		res = Math.sqrt(sq);

		return res;
	}

	public String run(int[] nums) {
		Node head = null;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			head = push(head, num);
		}
		double mean = avgOfNodes(head);
		double std = stdOfNodes(head, mean);
		String answer = "answer is " + String.valueOf(mean) + " " + String.valueOf(std);
		return answer;
	}

}
