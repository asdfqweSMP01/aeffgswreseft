
import java.util.Scanner;

public class StudentSM {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		short a=2+4;
		Scanner sr = new Scanner(System.in);
		Output csh = new Output(); // �����ʵ����
		StudentS xsc = new StudentS();
		short i;
		String xh;
		boolean tc = true;
		System.out.println("\n\t\t\t��������ӭʹ��ѧ���ɼ�����ϵͳ������\n");
		xsc.rK(); // �����������γ̲���
		csh.initial(true); // ����ļ���ʼ��
		do {
			System.out.println("\nϵͳ�˵���");
			System.out.println("\t01 ���һ��ѧ��");
			System.out.println("\t02����һ��ѧ��");
			System.out.println("\t03����ѧ����Ÿ���ѧ��������Ϣ");
			System.out.println("\t04����ѧ������ɾ��ѧ��");
			System.out.println("\t05����ѧ���������ѧ�����ųɼ�");
			System.out.println("\t06����ĳ�ųɼ���������");
			System.out.println("\t07�����ֽܷ�������");
			System.out.println("\t08 ��ʾ�ɼ���");
			System.out.println("\t00�˳�ϵͳ");
			System.out.println("������������ѡ�����Ĳ�����");
			xh = sr.next();
			switch (xh) {
			case "01":
				xsc.addStu(); // 01 ���һ��ѧ��
				break;
			case "02":
				xsc.query();// 02����һ��ѧ��
				break;
			case "03":
				xsc.modify();// 03����ѧ����Ÿ���ѧ��������Ϣ
				break;
			case "04":
				xsc.delete();// 04����ѧ����������ɾ��ѧ��
				break;
			case "05":
				xsc.enre();// 05����ѧ���������ѧ�����ųɼ�
				break;
			case "06":
				xsc.acsort();// 06����ĳ�ųɼ���������
				break;
			case "07":
				xsc.zfsort();// 07�����ֽܷ�������
				break;
			case "08":
				csh.refresh(); // 08��ʾ�ɼ���
				break;
			case "00":
				System.out.println("��ȷ��Ҫ�˳���\n\tY:�˳�\tE:�˳�����ӡ�ɼ���\tC:ȡ��");
				switch (sr.next()) {
				case "Y":
					tc = false;// 00�˳�ϵͳ					
					break;
				case "E":
					tc = false;// 00�˳�ϵͳ	
					csh.refresh(); // 08��ʾ�ɼ���
					break;
				case "C":
					tc = true;
					break;
				default:
					System.out.println("�������룡");
					break;
				}
				break;
			default:
				System.out.println("������Ч������\n");// �������
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					System.out.println("ϵͳ�����쳣��");
					e.printStackTrace();
				}
				System.out.println("����ȷ����������,��������...");
				break;
			}
		} while (tc);
		System.out.println("\n...ϵͳ���˳���\n��л����ʹ�ã�");
	}
}
