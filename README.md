# aeffgswreseft
drthastyhhshv

＃实验目的
初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法；
了解面向对象的类设计方法（属性、方法）；
了解类的继承用法，通过构造方法实例化对象；
学会使用super()，用于实例化子类；
学会使用Object根类的toString（）方法,应用在相关对象的信息输出中。

##业务要求：System.out.println("\n系统菜单：");
			System.out.println("\t01 添加一个学生");
			System.out.println("\t02查找一个学生");
			System.out.println("\t03根据学生编号更改学生基本信息");
			System.out.println("\t04根据学生姓名删除学生");
			System.out.println("\t05根据学生编号输入学生各门成绩");
			System.out.println("\t06根据某门成绩进行排序");
			System.out.println("\t07根据总分进行排序");
			System.out.println("\t08 显示成绩表");
			System.out.println("\t00退出系统");
			System.out.println("请输入操作编号选择您的操作：");System.out.println("\n系统菜单：");
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

##实验过程
#1首先需要选择身份，学生或者是管理员，如果选择管理员需要输入密码，菜单上的选项有的只能管理员访问

比如创建菜单,有的只能学生访问，比如选课和创建学生。

#2创建学生，创建课程，都会将数据保存在数据库中

#3得到学生列表和课程列表都是从数据库中获取数据

#4登陆会从数据库中校验用户名和密码，修改密码也会同时修改数据库的密码

通过ID，USERNAME，PASSWORD登录

密码默认为12345，可以选择更改密码,若登陆失败会重新登陆

#5选课：会先显示出已经选择的课程，然后在从课程列表中选择新的课程

＃6退出系统：数据表：一共4张

学生表，课程表，按照实体类的的成员属性来存储字段类型

登陆表，存放学生登陆的用户名和密码

学生选课表，存放学生选择的课程

##核心方法

＃1初始化表格方法：initial

＃2更新成绩表方法：refresh

＃3初始化课程科目方法：rK

##实验结果

##实验感想
通过本次实验我熟悉了定义类的属性级方法，以及对象的·设计和子父类的使用方法。因为要实现打印课程列表的功能，我通过查询资料，掌握了基本的方法
并且如何进行退课也让我花费了很多能量。通过这次实验，使我对编程思路更加熟悉希望在将来的实验中，能够更加完善。

##流程图

##核心代码

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
![result](https://github.com/asdfqweSMP01/aeffgswreseft/upload/main)
