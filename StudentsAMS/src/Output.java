
public class Output {
	/*
	 * ��ʼ����񷽷�
	 */
	public void initial(boolean t) {
		System.out.println("\t\t\t������ѧ���ɼ�����ϵͳ__�ɼ�������\n");
		String[] title;
		title = new String[6 + StudentS.curriculum.length];
		if (t)
			title[0] = "ѧ��ID";
		else
			title[0] = "����";
		title[1] = "����";
		title[2] = "�Ա�";
		title[3] = "����";
		for (int i = 4; i < StudentS.curriculum.length + 4; i++) {
			title[i] = StudentS.curriculum[i - 4];
		}
		title[StudentS.curriculum.length + 5] = "ƽ����";
		title[StudentS.curriculum.length + 4] = "�ܷ�";
		for (int i = 0; i < title.length; i++) { // ��ͷ��������
			System.out.print("\t" + title[i]);
		}
	}

	/*
	 * ˢ�³ɼ�����
	 */
	public void refresh() {
		initial(true);
		for (int j = 0; j < StudentS.k; j++) {
			System.out.println();
			for (int i = 0; i < StudentS.y + 5; i++) { // �ɼ���¼��Ϣ�����
				if (i == 0)
					System.out.print("\t" + (j + 1));
				System.out.print("\t" + StudentS.record[j][i]);
			}
		}
	}

	/*
	 * �Ա��Ϊi��ѧ���ļ�¼�������
	 */
	public void ytjl(int i) {
		initial(true);
		System.out.print("\n\t" + (i + 1));
		for (int j = 0; j < StudentS.y + 5; j++) {
			System.out.print("\t" + StudentS.record[i][j]);
		}
	}

	/*
	 * ����ĳ�ųɼ����������������
	 */
	public void cjpx(int _n, boolean _m) {
		 // ѧ���������Ա�����
		String[][] StuNGA2 = new String[StudentS.x][3];
		// ����Ŀ�ĳɼ�
		double[][] SchRe2 = new double[StudentS.x][StudentS.y]; 
		 // ѧ���ɼ����¼����
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
		double[] sum = new double[SchRe2.length];// ��¼ÿһ���˵��ܷ�
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
