
import java.util.Scanner;

public class StudentSM {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		short a=2+4;
		Scanner sr = new Scanner(System.in);
		Output csh = new Output(); // 输出类实例化
		StudentS xsc = new StudentS();
		short i;
		String xh;
		boolean tc = true;
		System.out.println("\n\t\t\t···欢迎使用学生成绩管理系统···\n");
		xsc.rK(); // 设置人数、课程参数
		csh.initial(true); // 表格文件初始化
		do {
			System.out.println("\n系统菜单：");
			System.out.println("\t01 添加一个学生");
			System.out.println("\t02查找一个学生");
			System.out.println("\t03根据学生编号更改学生基本信息");
			System.out.println("\t04根据学生姓名删除学生");
			System.out.println("\t05根据学生编号输入学生各门成绩");
			System.out.println("\t06根据某门成绩进行排序");
			System.out.println("\t07根据总分进行排序");
			System.out.println("\t08 显示成绩表");
			System.out.println("\t00退出系统");
			System.out.println("请输入操作编号选择您的操作：");
			xh = sr.next();
			switch (xh) {
			case "01":
				xsc.addStu(); // 01 添加一个学生
				break;
			case "02":
				xsc.query();// 02查找一个学生
				break;
			case "03":
				xsc.modify();// 03根据学生编号更改学生基本信息
				break;
			case "04":
				xsc.delete();// 04根据学生（姓名）删除学生
				break;
			case "05":
				xsc.enre();// 05根据学生编号输入学生各门成绩
				break;
			case "06":
				xsc.acsort();// 06根据某门成绩进行排序
				break;
			case "07":
				xsc.zfsort();// 07根据总分进行排序
				break;
			case "08":
				csh.refresh(); // 08显示成绩表
				break;
			case "00":
				System.out.println("您确定要退出？\n\tY:退出\tE:退出并打印成绩表\tC:取消");
				switch (sr.next()) {
				case "Y":
					tc = false;// 00退出系统					
					break;
				case "E":
					tc = false;// 00退出系统	
					csh.refresh(); // 08显示成绩表
					break;
				case "C":
					tc = true;
					break;
				default:
					System.out.println("错误输入！");
					break;
				}
				break;
			default:
				System.out.println("输入无效操作！\n");// 输入错误
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					System.out.println("系统出现异常：");
					e.printStackTrace();
				}
				System.out.println("请正确输入操作序号,操作继续...");
				break;
			}
		} while (tc);
		System.out.println("\n...系统已退出！\n感谢您的使用！");
	}
}
