package 병사관리;

import java.util.*;

public class UserSolution {
	/** 기능
	 * 병사 추가
	 * 병사 삭제 
	 * 병사 찾아서 점수 변경 (점수 1~5)
	 * 팀 찾아서 점수 변경 (팀 1~5)
	 * 해당 팀중 점수 가장 높은 사람 찾기
	 */

	// HashMap<팀, TreeMap<점수, TreeSet<아이디>>>
	// HashMap<아이디, 팀>
	static HashMap<Integer, Man> total;
	static HashMap<Integer, TreeMap<Integer, TreeSet<Integer>>> team;

	public void init() {
		total = new HashMap<>();
		team = new HashMap<>();
		for(int i = 1; i <= 5; i++) {
			TreeMap<Integer, TreeSet<Integer>> score = new TreeMap<>();
			for (int j = 1; j <= 5; j++) {
				score.put(j, new TreeSet<>());
			}
			team.put(i, score);	
		}
	}

	public void hire(int mID, int mTeam, int mScore) {
		total.put(mID, new Man(mTeam, mScore));

		TreeMap<Integer, TreeSet<Integer>> scoreMap = team.get(mTeam);
		TreeSet<Integer> memberSet = scoreMap.get(mScore);
		memberSet.add(mID);
		scoreMap.put(mScore, memberSet);
		team.put(mTeam, scoreMap);
	}

	public void fire(int mID) {
		Man man = total.get(mID);
		int t = man.team;
		int s = man.score;
		total.remove(mID); //  이거 있어야 하나?
		
		TreeMap<Integer, TreeSet<Integer>> scoreMap = team.get(t);
		TreeSet<Integer> memberSet = scoreMap.get(s);
		memberSet.remove(mID);
		scoreMap.put(s, memberSet);
		team.put(t, scoreMap);
	}

	public void updateSoldier(int mID, int mScore) {
		Man man = total.get(mID);
		int t = man.team;
		int s = man.score;
		total.put(mID, new Man(t, mScore));

		TreeMap<Integer, TreeSet<Integer>> scoreMap = team.get(t);
		TreeSet<Integer> originalSet = scoreMap.get(s);
		originalSet.remove(mID);
		scoreMap.put(s, originalSet);

		TreeSet<Integer> changeSet = scoreMap.get(mScore);
		changeSet.add(mID);
		scoreMap.put(mScore, changeSet);

		team.put(t, scoreMap);
	}

	public void updateTeam(int mTeam, int mChangeScore) {
		TreeMap<Integer, TreeSet<Integer>> scoreMap = team.get(mTeam);
		TreeSet<Integer>[] nSet = new TreeSet[6];
		for (int i = 1; i <= 5; i++) {
			nSet[i] = new TreeSet<>();
		}

		int nScore;
		for (int i = 1; i <= 5; i++) {
			nScore = i + mChangeScore;
			TreeSet<Integer> set = scoreMap.remove(i);
			System.out.println("nScore: " + nScore);
			if (nScore < 1) {
				nSet[1].addAll(set);
				System.out.println("1보다 작음");
			}
			if (nScore > 5) {
				nSet[5].addAll(set);
				System.out.println("5보다 큼");
			} 
			else {
				nSet[nScore].addAll(set);
			}
		}

		for (int i = 1; i <= 5; i++) {
			scoreMap.put(i, nSet[i]);
		}
	}

	public int bestSoldier(int mTeam) {
		int bestMan = -1;
		TreeMap<Integer, TreeSet<Integer>> scoreMap = team.get(mTeam);
		for (int i = 5; i >= 1; i++) {
			if (!scoreMap.containsKey(i) || scoreMap.get(i).size() == 0)
				continue;
			bestMan = scoreMap.get(i).last();
			break;
		}
		System.out.println(bestMan);
		return bestMan;
	}

	static class Man {
		int team, score;

		public Man(int team, int score) {
			this.team = team;
			this.score = score;
		}

	}
}
