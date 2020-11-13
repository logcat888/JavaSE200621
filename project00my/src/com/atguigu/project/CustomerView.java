package com.atguigu.project;

/**
 * @author chenhuiup
 * @create 2020-07-06 下午 2:31
 */
public class CustomerView {
    //用途：显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法（如addNewCustomer），以完成客户信息处理。
    CustomerList list1 = new CustomerList(10);

    public void enterMainMenu(){
        Customer customer = new Customer("张三",'男',30,"010-56253825","abc@email.com");
        list1.addCustomer(customer);
        for (;;){
            System.out.println("-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");
            char selection = CMUtility.readMenuSelection();
            if (selection == '1'){
//                System.out.println("添加客户");
                addNewCustomer();
            }else if (selection == '2'){
//                System.out.println("修 改 客 户");
                modifyCustomer();
            }else if (selection == '3'){
//                System.out.println("删 除 客 户");
                deleteCustomer();
            }else if (selection == '4'){
//                System.out.println("客 户 列 表");
                listAllCustomers();
            }else {
                return;
            }
        }
    }

    /**
     * 添加客户
     */
    private void addNewCustomer(){

            System.out.println("---------------------添加客户---------------------");
            System.out.print("姓名：");
            String name = CMUtility.readString(10);
            System.out.print("性别：");
            char gender = CMUtility.readChar();
            System.out.print("年龄：");
            int age = CMUtility.readInt();
            System.out.print("电话：");
            String phone = CMUtility.readString(11);
            System.out.print("邮箱：");
            String email = CMUtility.readString(25);

            Customer customer = new Customer(name, gender, age, phone, email);
            boolean isAddOrNot = list1.addCustomer(customer);
            if (isAddOrNot) {
                System.out.print("---------------------添加完成---------------------");
            }else {
                System.out.print("----------------记录已满,无法添加-----------------");

            }
    }

    /**
     * 修改客户
      */
    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        int index;//客户索引
        Customer customer;
        for (;;){
            System.out.println("请选择待修改客户编号(-1退出)：");
            index = CMUtility.readInt();
            customer= list1.getCustomer(index);
            if (customer == null){
                System.out.println("无法找到指定客户！");
                continue;
            } else {
                break;
            }
        }
        System.out.print("姓名：(" + customer.getName() + "):");
        String name = CMUtility.readString(10,customer.getName());
        System.out.print("性别：(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.print("年龄：(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("电话：(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(11,customer.getPhone());
        System.out.print("邮箱：(" + customer.getEmail() + "):");
        String email = CMUtility.readString(25,customer.getEmail());
        Customer customer1 = new Customer(name,gender,age,phone,email);
        list1.replaceCustomer(index,customer1);
        System.out.println("---------------------修改完成---------------------");

    }

    /**
     * 删除客户
     */
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        int index;//客户索引
        Customer customer;
        for (; ; ) {
            System.out.println("请选择待删除修改客户编号(-1退出)：");
            index = CMUtility.readInt();
            customer = list1.getCustomer(index);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
                continue;
            } else {
                break;
            }
        }
        System.out.println("确认是否删除(Y/N)：");
        char isDeleteOrNot = CMUtility.readConfirmSelection();
        if (isDeleteOrNot == 'Y'){
            list1.deleteCustomer(index);
            System.out.println("---------------------修改完成---------------------");
        }



    }

    /**
     * 客户列表
     */
    private void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
        Customer[] cust = list1.getAllCustomers();
        for (int i = 0; i < cust.length; i++) {
            System.out.println((i + 1)+ "\t\t" + cust[i].showInfo() );
        }
        System.out.println("---------------------------客户完成---------------------------");
    }

    //用途：创建CustomerView实例，并调用 enterMainMenu()方法以执行程序。
    public static void main(String[] args){
        CustomerView test = new CustomerView();
        test.enterMainMenu();
    }


}
