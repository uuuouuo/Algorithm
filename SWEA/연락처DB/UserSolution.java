package 연락처DB;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserSolution {

	static class Info {
		String name, num, birth, email, memo;

		public Info(String name, String num, String birth, String email, String memo) {
			this.name = name;
			this.num = num;
			this.birth = birth;
			this.email = email;
			this.memo = memo;
		}
	}

	static HashMap<Integer, HashMap<String, HashSet<Info>>> db;
	static int cnt;

	void InitDB() {
		db = new HashMap<>();
		for (int i = 0; i < 5; i++)
			db.put(i, new HashMap<String, HashSet<Info>>());
	}

	void Add(String name, String number, String birthday, String email, String memo) {
		Info info = new Info(name, number, birthday, email, memo);

		for (int i = 0; i < 5; i++) {
			String tmp = "";
			if (i == 0)
				tmp = name;
			if (i == 1)
				tmp = number;
			if (i == 2)
				tmp = birthday;
			if (i == 3)
				tmp = email;
			if (i == 4)
				tmp = memo;

			if (db.get(i).containsKey(tmp)) {
				db.get(i).get(tmp).add(info);
			} else {
				HashSet<Info> set = new HashSet<>();
				set.add(info);
				db.get(i).put(tmp, set);
			}
		}
	}

	// static void putDB(HashSet)

	int Delete(int field, String str) {
		if (!db.get(field).containsKey(str))
			return 0;

		cnt = 0;
		db.get(field).get(str).forEach(info -> {
			db.get(0).remove(info.name);
			db.get(1).remove(info.num);
			db.get(2).remove(info.birth);
			db.get(3).remove(info.email);
			db.get(4).remove(info.memo);
			cnt++;
		});

		return cnt;
	}

	static Info i;
	static HashMap<String, HashSet<Info>> tmpField;

	int Change(int field, String str, int changefield, String changestr) {
		if (!db.get(field).containsKey(str))
			return 0;

		i = null;
		// tmpField = db.get(changefield);
		// List<String> list = null;
		cnt = 0;
		db.get(field).get(str).forEach(info -> {
			if (changefield == 0) {
				i = new Info(changestr, info.num, info.birth, info.email, info.memo);
				db.get(changefield).remove(info.name);
			}
			if (changefield == 1) {
				i = new Info(info.name, changestr, info.birth, info.email, info.memo);
				db.get(changefield).remove(info.num);
			}
			if (changefield == 2) {
				i = new Info(info.name, info.num, changestr, info.email, info.memo);
				db.get(changefield).remove(info.birth);
			}
			if (changefield == 3) {
				i = new Info(info.name, info.num, info.birth, changestr, info.memo);
				db.get(changefield).remove(info.email);
			}
			if (changefield == 4) {
				i = new Info(info.name, info.num, info.birth, info.email, changestr);
				db.get(changefield).remove(info.memo);
			}

			if (db.get(changefield).containsKey(changestr)) {
				db.get(changefield).get(changestr).add(i);
			} else {
				HashSet<Info> set = new HashSet<>();
				set.add(i);
				db.get(changefield).put(changestr, set);
			}
			// 변경값 지워야하는데 지금 흠..

			if (changefield != 0) {
				HashSet<Info> set = db.get(0).get(info.name);
				set.add(i);
				set.remove(info);
				db.get(0).put(info.name, set);
			}
			if (changefield != 1) {
				HashSet<Info> set = db.get(1).get(info.num);
				set.add(i);
				set.remove(info);
				db.get(1).put(info.num, set);
			}
			if (changefield != 2) {
				HashSet<Info> set = db.get(2).get(info.birth);
				set.add(i);
				set.remove(info);
				db.get(2).put(info.birth, set);
			}
			if (changefield != 3) {
				HashSet<Info> set = db.get(3).get(info.email);
				set.add(i);
				set.remove(info);
				db.get(3).put(info.email, set);
			}
			if (changefield != 4) {
				HashSet<Info> set = db.get(4).get(info.memo);
				set.add(i);
				set.remove(info);
				db.get(4).put(info.name, set);
			}
			cnt++;
		});

		return cnt;
	}

	Solution.Result Search(int field, String str, int returnfield) {
		Solution.Result result = new Solution.Result();
		result.count = 0;
		result.str = "";

		if (!db.get(field).containsKey(str))
			return result;

		db.get(field).get(str).forEach(info -> {
			result.count++;

			if (returnfield == 0 && result.count == 1)
				result.str = info.name;
			if (returnfield == 1 && result.count == 1)
				result.str = info.num;
			if (returnfield == 2 && result.count == 1)
				result.str = info.birth;
			if (returnfield == 3 && result.count == 1)
				result.str = info.email;
			if (returnfield == 4 && result.count == 1)
				result.str = info.memo;
		});

		if (result.count > 1)
			result.str = "";

		return result;
	}

}
