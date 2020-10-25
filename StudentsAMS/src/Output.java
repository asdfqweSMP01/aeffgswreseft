
public class Output {
	/*
	 * 初始化表格方法
	 */
	public void initial(boolean t) {
		System.out.println("\t\t\t···学生成绩管理系统__成绩表···\n");
		String[] title;
		title = new String[6 + StudentS.curriculum.length];
		if (t)
			title[0] = "学生ID";
		else
			title[0] = "排名";
		title[1] = "姓名";
		title[2] = "性别";
		title[3] = "年龄";
		for (int i = 4; i < StudentS.curriculum.length + 4; i++) {
			title[i] = StudentS.curriculum[i - 4];
		}
		title[StudentS.curriculum.length + 5] = "平均分";
		title[StudentS.curriculum.length + 4] = "总分";
		for (int i = 0; i < title.length; i++) { // 表头标题的输出
			System.out.print("\t" + title[i]);
		}
	}

	/*
	 * 刷新成绩表方法
	 */
	public void refresh() {
		initial(true);
		for (int j = 0; j < StudentS.k; j++) {
			System.out.println();
			for (int i = 0; i < StudentS.y + 5; i++) { // 成绩记录信息的输出
				if (i == 0)
					System.out.print("\t" + (j + 1));
				System.out.print("\t" + StudentS.record[j][i]);
			}
		}
	}

	/*
	 * 对编号为i的学生的记录进行输出
	 */
	public void ytjl(int i) {
		initial(true);
		System.out.print("\n\t" + (i + 1));
		for (int j = 0; j < StudentS.y + 5; j++) {
			System.out.print("\t" + StudentS.record[i][j]);
		}
	}

	/*
	 * 根据某门成绩进行排序后进行输出
	 */
	public void cjpx(int _n, boolean _m) {
		 // 学生姓名、性别、年龄
		String[][] StuNGA2 = new String[StudentS.x][3];
		// 各科目的成绩
		double[][] SchRe2 = new double[StudentS.x][StudentS.y]; 
		 // 学生成绩表记录数组
		String[][] record2 = new String[StudentS.x][StudentS.y + 5];
		for (int i = 0; i < StudentS.k; i++) {
			for (int j = 0; j < StuNGA2[0].length; j++) {
				StuNGA2[i][j] = StudentS.StuNGA[i][j];
			}
		}
		for (int i = 0; i < StudentS.k; i++) {
			for (int j = 0; j < record2[0].length; j++) {
				record2[i][j] = StudentS.record[i][j];
			}
		}
		for (int i = 0; i < StudentS.k; i++) {
			for (int j = 0; j < SchRe2[0].length; j++) {
				SchRe2[i][j] = StudentS.SchRe[i][j];
			}
		}
		String[] b;
		double[] c;
		double d;
		double[] sum = new double[SchRe2.length];// 记录每一个人的总分
		for (int i = 0; i < SchRe2.length; i++) {
			for (int j = 0; j < SchRe2[i].length; j++) {
				sum[i] += SchRe2[i][j];
			}
		}
		for (int i = 0; i < StudentS.k; i++) {
			for (int j = 0; j < StudentS.k; j++) {
				if (_m) {
					if (sum[i] >= sum[j]) {
						d = sum[i];
						sum[i] = sum[j];
						sum[j] = d;
						b = record2[j];
						record2[j] = record2[i];
						record2[i] = b;
					}
				} else {
					if (SchRe2[i][_n] >= SchRe2[j][_n]) {
						c = SchRe2[j];
						SchRe2[j] = SchRe2[i];
						SchRe2[i] = c;
						b = record2[j];
						record2[j] = record2[i];
						record2[i] = b;
					}
				}
			}
		}
		Output sc = new Output();
		sc.initial(false);
		for (int i = 0; i < StudentS.k; i++) {
			System.out.println();
			System.out.print("\t" + (i + 1));
			for (int j = 0; j < record2[0].length; j++) {
				System.out.print("\t" + record2[i][j]);
			}
		}
	}
}
