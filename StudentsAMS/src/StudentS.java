import java.util.Scanner;

public class StudentS {
	Scanner Ssr = new Scanner(System.in);
	public static String[][] StuNGA; // ѧ���������Ա�����
	public static double[][] SchRe; // ����Ŀ�ĳɼ�
	public static String[] curriculum; // �γ̿�Ŀ
	public static String[][] record; // ѧ���ɼ����¼����
	public static int x = 0, y = 0;

	/*
	 * ��ʼ���γ̿�Ŀ����
	 */
	public void rK() {
		System.out.println("������ѧ������");
		while (!(Ssr.hasNextInt())) {
			System.out.println("������Ĳ���һ����������������룺");
			Ssr.next();
		}
		x = Ssr.nextInt();
		StuNGA = new String[x][3]; // ��ʼ��ѧ����Ϣ����
		System.out.println("������γ���");
		while (!(Ssr.hasNextInt())) {
			System.out.println("������Ĳ���һ����������������룺");
			Ssr.next();
		}
		y = Ssr.nextInt();
		curriculum = new String[y]; // ��ʼ���γ�����
		SchRe = new double[x][y]; // ��ʼ������Ŀ�ĳɼ�����
		record = new String[x][y + 5]; // ��ʼ��ѧ���ɼ����¼����
		System.out.println("������γ�����");
		for (int i = 0; i < curriculum.length; i++) {
			System.out.println("��" + (i + 1) + "�ſγ�:");
			curriculum[i] = Ssr.next();
		}
	}

	/*
	 * 01���һ��ѧ��
	 */
	public static int k = 0; // ����ȫ�ֱ�����ѧ��ʵ������

	public void addStu() {
		System.out.println("<����������01 ���һ��ѧ�����桤��������>");
		if (k == StuNGA.length) {
			System.out.println("ϵͳ�޶��������������ɼ������ѧ����");
		} else {
			StuNGA[k] = new String[3];
			SchRe[k] = new double[curriculum.length];// ����Ŀ�ɼ�����
			record[k] = new String[curriculum.length + 5];// ѧ����Ϣһ����¼
			System.out.println("������������");
			StuNGA[k][0] = Ssr.next();
			record[k][0] = StuNGA[k][0];
			System.out.println("�������Ա�");
			StuNGA[k][1] = Ssr.next();
			record[k][1] = StuNGA[k][1];
			while (!StuNGA[k][1].equals("��") && !StuNGA[k][1].equals("Ů")) {
				System.out.println("��������Ա���Ч�����������룺");
				StuNGA[k][1] = Ssr.next();
				record[k][1] = StuNGA[k][1];
			}
			System.out.println("���������䣺");
			while (!(Ssr.hasNextInt())) {
				System.out.println("����������䲻�Ϸ�������������������룺");
				Ssr.next();
			}
			StuNGA[k][2] = Ssr.next();
			record[k][2] = StuNGA[k][2];
			k++;
		}
	}

	/*
	 * 02����һ��ѧ��
	 */
	public static int l = 0; // ������ס��ѯѧ������Ż�ID

	public void query() {
		System.out.println("<����������02 ����һ��ѧ�����桤��������>");
		System.out.println("���������ѧ����������");
		if (cX() == -1)
			System.out.println("��ѯ���ݲ����ڣ�");
	}

	// �ദ�ظ����ã�������ȡ����
	private int cX() {
		int n = 0, m = 0;
		String xm;
		xm = Ssr.next();
		for (int i = 0; i < k; i++) {
			if (xm.equals(record[i][0])) {
				Output sc = new Output();
				sc.ytjl(i);// ��ӡ����ѧ���Ļ�����Ϣ���ɼ���¼
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
	 * 03 ����ѧ����Ÿ���ѧ��������Ϣ
	 */
	public void modify() {
		System.out.println("<����������03 ����ѧ����Ÿ���ѧ��������Ϣ���桤��������>");
		Output sc = new Output();
		int b1;
		String b2;
		if (k == 0) {
			System.out.println("���ݱ�Ϊ��,�������ɽ��У�");
		} else {
			System.out.println("������ѧ����ţ�");
			while (!(Ssr.hasNextInt())) {
				System.out.println("���Ϸ����룬���������룺");
				Ssr.next();
			}
			b1 = Ssr.nextInt();
			while (b1 <= 0 || b1 > k) {
				System.out.println("�����ѧ����Ų���ȷ�����������룺");
				while (!(Ssr.hasNextInt())) {
					System.out.println("���Ϸ����룬���������룺");
					Ssr.next();
				}
				b1 = Ssr.nextInt();
			}
			do {
				System.out.println("\n��ѡ���޸�" + StuNGA[b1 - 1][0] + "ͬѧ��Ϣ����Ӧ��ţ�\n\t1.����\t2.�Ա�\t3.����\t4.���ز˵�");
				while (!(Ssr.hasNextInt())) {
					System.out.println("���Ϸ����룬���������룺");
					Ssr.next();
				}
				b2 = Ssr.next();
				switch (b2) {
				case "1":
					// �޸�ѧ������
					System.out.println("������" + b1 + "��ѧ���µ�������");
					record[b1 - 1][0] = Ssr.next();
					StuNGA[b1 - 1][0] = record[b1 - 1][0];
					System.out.println("ѧ�������޸ĳɹ���");
					sc.ytjl(b1 - 1);// ��ӡ����ѧ���Ļ�����Ϣ���ɼ���¼
					break;
				case "2":
					// �޸�ѧ���Ա�
					System.out.println("������" + b1 + "��ѧ���µ��Ա�");
					record[b1 - 1][1] = Ssr.next();
					StuNGA[b1 - 1][1] = record[b1 - 1][1];
					while (!StuNGA[b1 - 1][1].equals("��") && !StuNGA[b1 - 1][1].equals("Ů")) {
						System.out.println("��������Ա���Ч�����������룺");
						record[b1 - 1][1] = Ssr.next();
						StuNGA[b1 - 1][1] = record[b1 - 1][1];
					}					
					System.out.println("ѧ���Ա��޸ĳɹ���");
					sc.ytjl(b1 - 1);// ��ӡ����ѧ���Ļ�����Ϣ���ɼ���¼
					break;
				case "3":
					// �޸�ѧ������
					System.out.println("������" + b1 + "��ѧ���µ����䣺");
					while (!(Ssr.hasNextInt())) {
						System.out.println("����������䲻�Ϸ�������������������룺");
						Ssr.next();
					}
					record[b1 - 1][2] = Ssr.next();
					StuNGA[b1 - 1][2] = record[b1 - 1][2];
					System.out.println("ѧ�������޸ĳɹ���");
					sc.ytjl(b1 - 1);// ��ӡ����ѧ���Ļ�����Ϣ���ɼ���¼
					break;
				case "4":
					break;
				default:
					System.out.println("�������������������룺");
					break;
				}
			} while (!b2.equals("4"));
		}
	}

	/*
	 * 04����ѧ����������ɾ��ѧ��
	 */
	public void delete() {
		System.out.println("<����������04 ����ѧ������ɾ��ѧ�����桤��������>");
		String _b;
		System.out.println("������Ҫɾ����ѧ����������");
		if (cX() == -1) {
			System.out.println("���ݲ����ڣ�");
		} else {
			System.out.println("\n�Ƿ�ɾ����ѧ����Ϣ����ɾ����Y\tȡ����C��");
			_b = Ssr.next();
			while (!(_b.equals("Y") || _b.equals("C"))) {
				System.out.println("��Ч���룡���������룺");
				_b = Ssr.next();
			}
			if (_b.equals("Y")) {
				// ���±�ΪL�������¼����ɾ��
				StuNGA = delAnyPosition(StuNGA, l);
				SchRe = delInt(SchRe, l);
				record = delAnyPosition(record, l);
				k -= 1;
				System.out.println("ɾ���ɹ���");
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
	 * 05����ѧ���������ѧ�����ųɼ�
	 */
	public void enre() {
		System.out.println("<����������05 ����ѧ���������ѧ�����ųɼ����桤��������>");
		double sum = 0;// �ܷ�
		if (k == 0) {
			System.out.println("ѧ����Ϣ��Ϊ�գ��������˵���");
			return;
		}
		System.out.println("������ѧ����ţ�");
		while (!(Ssr.hasNextInt())) {
			System.out.println("���Ϸ����룬���������룺");
			Ssr.next();
		}
		int n = Ssr.nextInt();
		while (n <= 0 || n > k) {
			System.out.println("�����ѧ����Ų���ȷ�����������룺");
			while (!(Ssr.hasNextInt())) {
				System.out.println("���Ϸ����룬���������룺");
				Ssr.next();
			}
			n = Ssr.nextInt();
		}
		if (record[n - 1][3 + curriculum.length] == null) {
			tjcj(sum, n);
		} else {
			String _b;
			System.out.println("��ѧ���ɼ���Ϣ�ǿգ��Ƿ���ģ�\n\tY������\tC��ȡ��");
			_b = Ssr.next();
			while (!(_b.equals("Y") || _b.equals("C"))) {
				System.out.println("��Ч���룡���������룺");
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
	 * ѧ���ɼ�����
	 */
	private void tjcj(double sum, int n) {
		System.out.println("������" + StuNGA[n - 1][0] + "�ĳɼ���");
		for (int i = 0; i < curriculum.length; i++) {
			System.out.println("������" + curriculum[i] + "�ɼ���");
			while (!(Ssr.hasNextDouble())) {
				System.out.println("���Ϸ����룬���������룺");
				Ssr.next();
			}
			SchRe[n - 1][i] = Ssr.nextDouble();
			record[n - 1][i + 3] = String.valueOf(SchRe[n - 1][i]);
			sum += SchRe[n - 1][i];
		}
		record[n - 1][3 + curriculum.length] = String.valueOf(sum);// ������Ҫ������λ��Ч���֣���ͬ
		record[n - 1][4 + curriculum.length] = String.valueOf(sum / curriculum.length);
	}

	/*
	 * 06����ĳ�ųɼ���������
	 */
	public void acsort() {
		System.out.println("<����������06 ����ĳ�ųɼ�����������桤��������>");
		if (k == 0) {
			System.out.println("ѧ����Ϣ��Ϊ�գ��������˵���");
			return;
		}
		for (int i = 0; i < k; i++) {
			for (int j = 3; j < record[i].length; j++) {
				if (record[i][j] == null) {
					System.out.println("ѧ���ɼ������ƣ������ƺ��ٽ�������");
					return;
				}
			}
		}
		System.out.println("��ѡ������Ҫ����Ŀ�Ŀ�������롰C����������");
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
				System.out.println("��Ŀ����������������룺");
			}
		} while (true);
	}
/*
 * 07�����ֽܷ�������
 */
	public void zfsort() {
		System.out.println("<����������07 �����ֽܷ���������桤��������>");
		if (k == 0) {
			System.out.println("ѧ����Ϣ��Ϊ�գ��������˵���");
			return;
		}
		for (int i = 0; i < k; i++) {
			for (int j = 3; j < record[i].length; j++) {
				if (record[i][j] == null) {
					System.out.println("ѧ���ɼ������ƣ������ƺ��ٽ�������");
					return;
				}
			}
		}
		Output sc = new Output();
		sc.cjpx(0, true);
	}
}
