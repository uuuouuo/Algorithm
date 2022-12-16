package 기초PartialSort연습;

public class UserSolution {

	// 배열, Linked List 두가지 방법
	// 최대 10개만 체크
	static class User {
		int id, income;
		public User(int id, int income) {
			this.id = id;
			this.income = income;
		}
	}
	static User[] input;
	static int minIncome, minIdx, idx;
	
	public void init() {
		System.out.println("init !!!");
		input = new User[10];
		minIncome = Integer.MAX_VALUE;
//		minIdx = 0;
		idx = -1;
	}

	public void addUser(int uID, int income) {
		System.out.println("add !!!");
		System.out.println(uID+" "+income);
		if(idx < 9) {
			System.out.println("idx < 9");
			input[++idx] = new User(uID, income);
//			System.out.println(idx+" "+input[idx].id+" "+input[idx].income);
			if(idx == 0) return;
			insertionSort(idx);
		}	
		else {
			// 제일 작은 income 보다 더 작으면 버리기
			if(input[0].income > income) {
				System.out.println("최소보다 작아 !!!!");
				return;
			}
			
			else if((input[0].income == income)
					&& input[0].id > uID) { 
				System.out.println("같음 !!!!!!!");
				input[0].id = uID;
				input[0].income = income;
			}
			
			else {
				System.out.println("최소보다 큼 !!!!!!");
				input[0].id = uID;
				input[0].income = income;
				insertionSort(9);
				for(User i:input) {
					if(i == null) continue;
					System.out.println(i.id+" "+i.income);
				}
			}			
		}
		

		
	}
	
	static void insertionSort(int idx) {
		for (int i = 1; i <= idx; i++) {
			int cur = input[i].income;
			for (int j = i-1; j >= 0; j--) {
//				System.out.println(i+" "+j);
				if(cur > input[j].income) continue;
				
				int tmp = input[i].income;
				input[i].income = input[j].income;
				input[j].income = tmp;
				
				tmp = input[i].id;
				input[i].id = input[j].id;
				input[j].id = tmp;
			}
		}
	}

	int getTop10(int[] result) {
		System.out.println("top10 !!!");
		for(User i:input) {
			if(i == null) continue;
			System.out.println(i.id+" "+i.income);
		}
		return 0;
	}
}
