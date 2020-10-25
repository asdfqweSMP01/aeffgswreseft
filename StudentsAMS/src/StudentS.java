import java.util.Scanner;

public class StudentS {
	Scanner Ssr = new Scanner(System.in);
	public static String[][] StuNGA; // 学生姓名、性别、年龄
	public static double[][] SchRe; // 各科目的成绩
	public static String[] curriculum; // 课程科目
	public static String[][] record; // 学生成绩表记录数组
	public static int x = 0, y = 0;

	/*
	 * 初始化课程科目方法
	 */
	public void rK() {
		System.out.println("请输入学生人数");
		while (!(Ssr.hasNextInt())) {
			System.out.println("您输入的不是一个整数，请继续输入：");
			Ssr.next();
		}
		x = Ssr.nextInt();
		StuNGA = new String[x][3]; // 初始化学生信息数组
		System.out.println("请输入课程数");
		while (!(Ssr.hasNextInt())) {
			System.out.println("您输入的不是一个整数，请继续输入：");
			Ssr.next();
		}
		y = Ssr.nextInt();
		curriculum = new String[y]; // 初始化课程数组
		SchRe = new double[x][y]; // 初始化各科目的成绩数组
		record = new String[x][y + 5]; // 初始化学生成绩表记录数组
		System.out.println("请输入课程名：");
		for (int i = 0; i < curriculum.length; i++) {
			System.out.println("第" + (i + 1) + "门课程:");
			curriculum[i] = Ssr.next();
		}
	}

	/*
	 * 01添加一个学生
	 */
	public static int k = 0; // 定义全局变量，学生实际人数

	public void addStu() {
		System.out.println("<——···01 添加一个学生界面···——>");
		if (k == StuNGA.length) {
			System.out.println("系统限定人数已满，不可继续添加学生！");
		} else {
			StuNGA[k] = new String[3];
			SchRe[k] = new double[curriculum.length];// 各科目成绩数组
			record[k] = new String[curriculum.length + 5];// 学生信息一条记录
			System.out.println("请输入姓名：");
			StuNGA[k][0] = Ssr.next();
			record[k][0] = StuNGA[k][0];
			System.out.println("请输入性别：");
			StuNGA[k][1] = Ssr.next();
			record[k][1] = StuNGA[k][1];
			while (!StuNGA[k][1].equals("男") && !StuNGA[k][1].equals("女")) {
				System.out.println("您输入的性别无效，请重新输入：");
				StuNGA[k][1] = Ssr.next();
				record[k][1] = StuNGA[k][1];
			}
			System.out.println("请输入年龄：");
			while (!(Ssr.hasNextInt())) {
				System.out.println("您输入的年龄不合法（整数），请继续输入：");
				Ssr.next();
			}
			StuNGA[k][2] = Ssr.next();
			record[k][2] = StuNGA[k][2];
			k++;
		}
	}

	/*
	 * 02查找一个学生
	 */
	public static int l = 0; // 申明记住查询学生的序号或ID

	public void query() {
		System.out.println("<——···02 查找一个学生界面···——>");
		System.out.println("请输入查找学生的姓名：");
		if (cX() == -1)
			System.out.println("查询数据不存在！");
	}

	// 多处重复引用，所以提取方法
	private int cX() {
		int n = 0, m = 0;
		String xm;
		xm = Ssr.next();
		for (int i = 0; i < k; i++) {
			if (xm.equals(record[i][0])) {
				Output sc = new Output();
				sc.ytjl(i);// 打印出该学生的基本信息即成绩记录
				n++;
				l = i;
				return 0;
			}
		}
		if (n == 0)
			m = -1;
		return m;
	}

	/*
	 * 03 根据学生编号更改学生基本信息
	 */
	public void modify() {
		System.out.println("<——···03 根据学生编号更改学生基本信息界面···——>");
		Output sc = new Output();
		int b1;
		String b2;
		if (k == 0) {
			System.out.println("数据表为空,操作不可进行！");
		} else {
			System.out.println("请输入学生编号：");
			while (!(Ssr.hasNextInt())) {
				System.out.println("不合法输入，请重新输入：");
				Ssr.next();
			}
			b1 = Ssr.nextInt();
			while (b1 <= 0 || b1 > k) {
				System.out.println("输入的学生编号不正确，请重新输入：");
				while (!(Ssr.hasNextInt())) {
					System.out.println("不合法输入，请重新输入：");
					Ssr.next();
				}
				b1 = Ssr.nextInt();
			}
			do {
				System.out.println("\n请选择修改" + StuNGA[b1 - 1][0] + "同学信息的相应编号：\n\t1.姓名\t2.性别\t3.年龄\t4.返回菜单");
				while (!(Ssr.hasNextInt())) {
					System.out.println("不合法输入，请重新输入：");
					Ssr.next();
				}
				b2 = Ssr.next();
				switch (b2) {
				case "1":
					// 修改学生姓名
					System.out.println("请输入" + b1 + "号学生新的姓名：");
					record[b1 - 1][0] = Ssr.next();
					StuNGA[b1 - 1][0] = record[b1 - 1][0];
					System.out.println("学生姓名修改成功！");
					sc.ytjl(b1 - 1);// 打印出该学生的基本信息即成绩记录
					break;
				case "2":
					// 修改学生性别
					System.out.println("请输入" + b1 + "号学生新的性别：");
					record[b1 - 1][1] = Ssr.next();
					StuNGA[b1 - 1][1] = record[b1 - 1][1];
					while (!StuNGA[b1 - 1][1].equals("男") && !StuNGA[b1 - 1][1].equals("女")) {
						System.out.println("您输入的性别无效，请重新输入：");
						record[b1 - 1][1] = Ssr.next();
						StuNGA[b1 - 1][1] = record[b1 - 1][1];
					}					
					System.out.println("学生性别修改成功！");
					sc.ytjl(b1 - 1);// 打印出该学生的基本信息即成绩记录
					break;
				case "3":
					// 修改学生年龄
					System.out.println("请输入" + b1 + "号学生新的年龄：");
					while (!(Ssr.hasNextInt())) {
						System.out.println("您输入的年龄不合法（整数），请继续输入：");
						Ssr.next();
					}
					record[b1 - 1][2] = Ssr.next();
					StuNGA[b1 - 1][2] = record[b1 - 1][2];
					System.out.println("学生姓名修改成功！");
					sc.ytjl(b1 - 1);// 打印出该学生的基本信息即成绩记录
					break;
				case "4":
					break;
				default:
					System.out.println("序号输入错误，请重新输入：");
					break;
				}
			} while (!b2.equals("4"));
		}
	}

	/*
	 * 04根据学生（姓名）删除学生
	 */
	public void delete() {
		System.out.println("<——···04 根据学生姓名删除学生界面···——>");
		String _b;
		System.out.println("请输入要删除的学生的姓名：");
		if (cX() == -1) {
			System.out.println("数据不存在！");
		} else {
			System.out.println("\n是否删除该学生信息？（删除：Y\t取消：C）");
			_b = Ssr.next();
			while (!(_b.equals("Y") || _b.equals("C"))) {
				System.out.println("无效输入！请重新输入：");
				_b = Ssr.next();
			}
			if (_b.equals("Y")) {
				// 对下表为L的数组记录进行删除
				StuNGA = delAnyPosition(StuNGA, l);
				SchRe = delInt(SchRe, l);
				record = delAnyPosition(record, l);
				k -= 1;
				System.out.println("删除成功！");
			}
		}
	}

	public static double[][] delInt(double[][] schRe2, int position) {
		double[][] res = new double[schRe2.length][];
		for (int i = 0; i < res.length; i++) {
			if (i < position) {
				res[i] = schRe2[i];
			} else {
				if (i == res.length - 1) {
					res[i] = null;
				} else
					res[i] = schRe2[i + 1];
			}
		}
		return res;
	}

	public static String[][] delAnyPosition(String[][] stu, int position) {
		String[][] res = new String[stu.length][];
		for (int i = 0; i < res.length; i++) {
			if (i < position) {
				res[i] = stu[i];
			} else {
				if (i == res.length - 1) {
					res[i] = null;
				} else
					res[i] = stu[i + 1];
			}
		}
		return res;
	}

	/*
	 * 05根据学生编号输入学生各门成绩
	 */
	public void enre() {
		System.out.println("<——···05 根据学生编号输入学生各门成绩界面···——>");
		double sum = 0;// 总分
		if (k == 0) {
			System.out.println("学生信息表为空，返回主菜单！");
			return;
		}
		System.out.println("请输入学生编号：");
		while (!(Ssr.hasNextInt())) {
			System.out.println("不合法输入，请重新输入：");
			Ssr.next();
		}
		int n = Ssr.nextInt();
		while (n <= 0 || n > k) {
			System.out.println("输入的学生编号不正确，请重新输入：");
			while (!(Ssr.hasNextInt())) {
				System.out.println("不合法输入，请重新输入：");
				Ssr.next();
			}
			n = Ssr.nextInt();
		}
		if (record[n - 1][3 + curriculum.length] == null) {
			tjcj(sum, n);
		} else {
			String _b;
			System.out.println("该学生成绩信息非空，是否更改？\n\tY：更改\tC：取消");
			_b = Ssr.next();
			while (!(_b.equals("Y") || _b.equals("C"))) {
				System.out.println("无效输入！请重新输入：");
				_b = Ssr.next();
			}
			if (_b.equals("Y")) {
				tjcj(sum, n);
			} else {
				return;
			}
		}
	}

	/*
	 * 学生成绩输入
	 */
	private void tjcj(double sum, int n) {
		System.out.println("请输入" + StuNGA[n - 1][0] + "的成绩：");
		for (int i = 0; i < curriculum.length; i++) {
			System.out.println("请输入" + curriculum[i] + "成绩：");
			while (!(Ssr.hasNextDouble())) {
				System.out.println("不合法输入，请重新输入：");
				Ssr.next();
			}
			SchRe[n - 1][i] = Ssr.nextDouble();
			record[n - 1][i + 3] = String.valueOf(SchRe[n - 1][i]);
			sum += SchRe[n - 1][i];
		}
		record[n - 1][3 + curriculum.length] = String.valueOf(sum);// 这里需要保留两位有效数字，下同
		record[n - 1][4 + curriculum.length] = String.valueOf(sum / curriculum.length);
	}

	/*
	 * 06根据某门成绩进行排序
	 */
	public void acsort() {
		System.out.println("<——···06 根据某门成绩进行排序界面···——>");
		if (k == 0) {
			System.out.println("学生信息表为空，返回主菜单！");
			return;
		}
		for (int i = 0; i < k; i++) {
			for (int j = 3; j < record[i].length; j++) {
				if (record[i][j] == null) {
					System.out.println("学生成绩表不完善，请完善后再进行排序");
					return;
				}
			}
		}
		System.out.println("请选择您想要排序的科目：（输入“C”结束排序）");
		for (int i = 0; i < curriculum.length; i++) {
			System.out.print("\t" + curriculum[i]);
		}
		System.out.println();
		String km;
		int _n;
		do {
			_n = 0;
			km = Ssr.next();
			for (int i = 0; i < curriculum.length; i++) {
				if (km.equals(curriculum[i])) {
					Output sc = new Output();
					sc.cjpx(i, false);
					return;
				} else {
					_n++;
				}
			}
			if (km.equals("C")) {
				return;
			}
			if (_n != 0) {
				System.out.println("科目输入错误，请重新输入：");
			}
		} while (true);
	}
/*
 * 07根据总分进行排序
 */
	public void zfsort() {
		System.out.println("<——···07 根据总分进行排序界面···——>");
		if (k == 0) {
			System.out.println("学生信息表为空，返回主菜单！");
			return;
		}
		for (int i = 0; i < k; i++) {
			for (int j = 3; j < record[i].length; j++) {
				if (record[i][j] == null) {
					System.out.println("学生成绩表不完善，请完善后再进行排序");
					return;
				}
			}
		}
		Output sc = new Output();
		sc.cjpx(0, true);
	}
}
