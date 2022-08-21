package SocialMedia;

import java.util.*;

public class UserSolution {

	static class Feed {
		int uId, fId, like, time;

		public Feed(int uId, int fId, int time) {
			this.uId = uId;
			this.fId = fId;
			this.time = time;
			this.like = 0;
		}

		public Feed(int fId) {
			this.fId = fId;
		}
	}

	static HashMap<Integer, Feed> feeds;
	static HashMap<Integer, HashSet<Integer>> users; // 유저ID, 팔로우set

	public void init(int N) { // N 사용자 수 : 1000
		feeds = new HashMap<>();
		users = new HashMap<>(N);
	}

	// 1 -> 2 팔로우list에 추가 2의 모든 게시물 볼 수 있음
	public void follow(int uID1, int uID2, int timestamp) {
		HashSet set;
		if (!users.containsKey(uID1)) {
			set = new HashSet<>();
			set.add(uID2);
			users.put(uID1, set);
		} else
			users.get(uID1).add(uID2);

		if (!users.containsKey(uID2)) {
			set = new HashSet<>();
			users.put(uID2, set);
		}
	}

	// 게시물 등록 -> 일단 정렬되는지 확인
	public void makePost(int uID, int pID, int timestamp) {
		feeds.put(pID, new Feed(uID, pID, timestamp));
	}

	public void like(int pID, int timestamp) {
		feeds.get(pID).like++;
	}

//	static class Like implements Comparable<Like> {
//		int fId, like;
//
//		public Like(int fId) {
//			this.fId = fId;
//			this.like = 0;
//		}
//
//		public int compareTo(Like n) {
//			if (this.like == n.like)
//				return n.fId - this.fId;
//			return n.like - this.like;
//		}
//
//		public boolean equals(Object o) {
//			Like like = (Like) o;
//			return like.fId == this.fId;
//		}
//
//		public int hashCode() {
//			return Objects.hash(fId);
//		}
//	}

	static int idx;

	public void getFeed(int uID, int timestamp, int pIDList[]) {
		List<Feed> feedList = new ArrayList<>(feeds.values());
		List<Feed> tmpList = new ArrayList<>(10);

//		System.out.println("----------- 유저: " + uID+" ----------");
//		users.get(uID).forEach(u -> System.out.print(u+" "));
//		System.out.println();
//		System.out.println("-------------- 피드리스트 --------------");
//		feedList.forEach(f -> System.out.println("유저: "+f.uId+" 피드: "+f.fId+" 좋아요: "+f.like+" 작성시간: "+f.time));

		idx = 0;
		int size = feedList.size();
		for (int i = size - 1; i >= 0; i--) {
			Feed f = feedList.get(i);

			if (idx == 10)
				break;

			// 이 유저의 팔로윙한 사람이라면 & 자기자신 포함!!!
			if (users.get(uID).contains(f.uId) || f.uId == uID) {
				if (timestamp - f.time <= 1000) {
					tmpList.add(f);
					insertionSort(pIDList, tmpList); // like 순 정렬필요
					idx = tmpList.size();
				} else {
					pIDList[idx++] = f.fId;
				}
			}
		}
		
		if(tmpList.size() == 0) {
			pIDList = new int[10];
			return;
		}
		
		for (int i = idx; i < 10; i++) {
			if(pIDList[i] != 0)
				pIDList[i] = 0;
		}

//		System.out.println("타임스템프: "+ timestamp);
//		System.out.print("결과: ");
//		for(int p:pIDList)
//			System.out.print(p+" ");
//		System.out.println();

	}

	private void insertionSort(int[] pIDList, List<Feed> tmpList) {
		Collections.sort(tmpList, (f1, f2) -> {
			if (f1.like == f2.like)
				return f2.fId - f1.fId;
			return f2.like - f1.like;
		});
		
//		for(Feed f:tmpList)
//			System.out.print(f.fId+" ");
//		System.out.println();
		
		int size = tmpList.size();
		for (int i = 0; i < size; i++) {
			pIDList[i]= tmpList.get(i).fId; 
		}
	}
}
