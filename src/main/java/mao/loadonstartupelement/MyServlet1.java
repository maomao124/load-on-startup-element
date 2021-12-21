package mao.loadonstartupelement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：load-on-startup-element
 * Package(包名): mao.loadonstartupelement
 * Class(类名): MyServlet1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/21
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)：
 * load-on-startup 是 web.xml 中的一个节点，是 servlet 元素的子元素，
 * 用来标记 Servlet 容器启动时是否初始化当前 Servlet，以及当前 Servlet 的初始化顺序。
 * load-on-startup 元素取值规则如下：
 * 它的取值必须是一个整数；
 * 当值小于 0 或者没有指定时，则表示容器在该 Servlet 被首次请求时才会被加载；
 * 当值大于 0 或等于 0 时，表示容器在启动时就加载并初始化该 Servlet，取值越小，优先级越高；
 * 当取值相同时，容器就会自行选择顺序进行加载。
 *
 * 由于 MyServlet1、MyServlet2 和 MyServlet3 的 load-on-startup 元素取值都大于等于 0，因此当 Tomcat 启动时，就对它们进行了初始化。
 * 由于在 Servlet 的生命周期内，init() 方法（初始化方法）只能被调用一次，因此当 Tomcat 启动完成后，
 * 第一次访问 MyServlet1、MyServlet2 和 MyServlet3 时，它们不会再次被初始化。
 * 由于 MyServlet4 的 load-on-startup 元素取值为负数，因此只有当第一次请求它时，才会进行初始化。
 * 由于 MyServlet5  没有指定 load-on-startup 元素取值，因此只有当第一次请求它时，才会进行初始化。
 */

public class MyServlet1 extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }

    @Override
    public void destroy()
    {
        System.out.println(this.getServletName() + "：销毁");
    }

    @Override
    public void init() throws ServletException
    {
        System.out.println(this.getServletName() + "：初始化完成");
    }
}
