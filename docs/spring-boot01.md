# Spring Boot 概述

Spring Boot 是 [Spring](https://spring.io/) 框架的一个子项目，专门用于简化基于 Spring 的 Java 应用程序开发。它通过提供预先配置的框架和自动化配置，减少了开发人员手动配置的复杂性，使他们能够快速构建和运行生产级别的应用程序。

<img src="https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409061933937.png" alt="image-20240906193336854" style="zoom:67%;" />

Spring Boot 的主要目标是让开发人员无需繁琐的 XML 或复杂的 Spring 配置即可启动项目。它通过嵌入式服务器（如 Tomcat 和
Jetty）以及自动配置和 "starter" 依赖来简化开发过程。这意味着开发人员无需手动配置服务器或处理兼容性问题，应用程序可以直接运行。此外，SpringBoot 提供了丰富的生产就绪特性，如健康检查、监控、外部化配置等，确保应用程序在生产环境中具备良好的运行状态。

> [!NOTE] 什么是 starter
> 
> Spring Boot Starter 是一组帮助简化依赖管理的 Maven POM 文件。每个 Starter 都包含一组常见的依赖项，适用于特定功能或技术栈。开发人员只需添加一个
> Starter 依赖，就能自动引入该功能所需的所有库和配置，无需手动列出每个单独的依赖。
> 例如，要开发一个 Web 应用程序，通常需要引入 Spring MVC、Tomcat 以及 JSON 处理库 Jackson 等。这些依赖通过
> spring-boot-starter-web 一个依赖项就能全部引入，大大减少了配置复杂度
> 常见的 starter 例子：
> 
> - spring-boot-starter-web：用于开发 Web 和 RESTful 应用。
> - spring-boot-starter-data-jpa：提供与 JPA 数据库交互的功能。
> - spring-boot-starter-test：包含 JUnit、Mockito、Spring Test 等用于测试的依赖项。
> 
> 命名规范
> 
> Spring Boot 官方的 starter 通常以 spring-boot-starter- 开头，后面跟随特定功能或技术的名称。例如，spring-boot-starter-security 用于安全功能，spring-boot-starter-data-jpa 用于 JPA 数据访问。对于非官方的 starter，推荐遵循类似命名模式，以<library>-spring-boot-starter 的格式命名，如 mycompany-spring-boot-starter
> 
> 这种 starter 的命名规范确保了项目结构的一致性，并且帮助开发人员快速找到与需求相符的依赖项

这种设计特别适合构建微服务架构以及独立部署的应用程序，帮助开发者专注于业务逻辑而不是基础设施配置，大大提升了开发效率和应用程序的可维护性。通过使用 Spring Boot，开发者可以更快地交付高质量的软件，而无需投入大量时间在基础设施管理上。你可以使用 [Spring Initializr](https://start.spring.io/) 快速生成项目模板

<img src="https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409061932607.png" alt="image-20240906193248474" style="zoom:67%;" />

# Spring Boot 的特性

- 自动配置（Auto-Configuration）：Spring Boot 会根据项目中的依赖自动进行配置。例如，如果项目中有 H2 数据库的依赖，Spring Boot 会自动配置一个嵌入式数据库，而无需额外的手动配置。
- 独立运行：Spring Boot 应用可以打包成一个可执行的 JAR 文件，包含了嵌入式的 Tomcat、Jetty 或 Undertow 服务器，无需外部服务器即可运行。
- 简化的依赖管理：通过 Spring Boot 的“starter”依赖模块，开发人员可以快速引入常用的库。每个 starter 都包含了一组相互兼容的依赖，以减少版本冲突的问题。
- 监控和管理：Spring Boot 提供了丰富的监控和管理功能，内置的 actuator 模块可以方便地监控应用状态，包括健康检查、性能指标等。
- 微服务支持：Spring Boot 非常适合构建微服务应用，它简化了服务的创建、管理和部署，并且与 Spring Cloud 完美集成，方便实现服务发现、配置管理、负载均衡等功能。

---

对于开发人员 Spring Boot 有以下几点特点

- 开发效率高：由于自动配置和 starter 依赖，开发人员可以专注于业务逻辑，而不必纠结于繁琐的配置。
- 减少配置复杂度：Spring Boot 避免了大量的 XML 配置，并通过注解和自动化配置减少了手动操作。
- 社区支持强大：Spring Boot 拥有广泛的社区支持和文档资源，开发者能够方便地获取学习资料和解决问题的帮助。
- 测试友好：Spring Boot 提供了许多便捷的测试功能，例如通过 @SpringBootTest 注解可以快速加载应用上下文并进行集成测试。

---

Spring Boot 还适用于不同的架构

- 微服务架构：Spring Boot 非常适合构建和管理分布式微服务，它的自动化和独立部署特性让微服务的开发和部署变得更加简单。
- Web 应用：Spring Boot 提供了强大的 Web 开发功能，内置的 Spring MVC 和 REST API 支持可以快速构建响应式和基于 REST 的 Web
  服务。
- 独立应用：Spring Boot 可以让开发者轻松构建可以独立运行的 Java 应用，尤其适用于工具类或后台服务的开发。
- 企业级应用：Spring Boot 结合了 Spring 框架的所有优点，适合开发复杂的企业级应用程序，并且其模块化的设计让其具有很高的灵活性和可扩展性

> [!NOTE] Spring Boot 与传统 Spring 的区别
> 
> - 启动更简单：传统的 Spring 项目往往需要大量的配置文件，Spring Boot 则通过自动配置减少了这些配置，开发者可以通过极少的配置启动一个完整的应用。
> - 嵌入式服务器：传统的 Spring 项目通常需要在外部服务器上运行，而 Spring Boot 提供了嵌入式的 Tomcat、Jetty 等服务器，应用可以直接打包成
    JAR 文件并执行。
> - 依赖管理更简便：Spring Boot 的 starter 依赖模块让开发者无需手动管理多个库的兼容性，而传统的 Spring 项目则需要手动引入并配置各个依赖。
> - 无缝集成测试：Spring Boot 提供了许多专用的测试功能，例如可以轻松进行单元测试、集成测试，而传统的 Spring 测试环境设置较为复杂

# 第一个 Spring Boot 项目

下面将围绕 web 场景进行 第一个 Spring Boot 项目 的介绍

## 项目创建

<img src="https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062053211.png" alt="image-20240906205324125" style="zoom:67%;" />

## 自动配置

```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
        @AliasFor(
        annotation = EnableAutoConfiguration.class
    )
    Class<?>[] exclude() default {};

    @AliasFor(
        annotation = EnableAutoConfiguration.class
    )
    String[] excludeName() default {};

    @AliasFor(
        annotation = ComponentScan.class,
        attribute = "basePackages"
    )
    String[] scanBasePackages() default {};

    @AliasFor(
        annotation = ComponentScan.class,
        attribute = "basePackageClasses"
    )
    Class<?>[] scanBasePackageClasses() default {};

    @AliasFor(
        annotation = ComponentScan.class,
        attribute = "nameGenerator"
    )
    Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

    @AliasFor(
        annotation = Configuration.class
    )
    boolean proxyBeanMethods() default true;
}
```

## 依赖注入

```java
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mcdds")
public class MCDDController {

    private final MCDDSeries mcddSeries; // 通过 

    @GetMapping
    public MCDDSeries list() {
        return Optional.ofNullable(mcddSeries).orElse(new MCDDSeries());
    }

}
```

## 读取属性文件

```java
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mcdds")
public class MCDDController {

    private final MCDDSeries mcddSeries;

    @GetMapping
    public MCDDSeries list() {
        return Optional.ofNullable(mcddSeries).orElse(new MCDDSeries());
    }

}

@Data
public class MCDD {
    /**
     * 名称
     */
    private String name;
    /**
     * 图片地址
     */
    private String imgUrl;
}

@Data
@Component
@ConfigurationProperties("mcdd")
public class MCDDSeries {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 评论
     */
    private List<String> comments;
    /**
     * 内容
     */
    private Map<Integer,MCDD> mcdds;
}


```

```yaml
server:
  port: 8081
mcdd:
  id: 39
  name: 抹茶旦旦 39
  comments:
    - 吃俺老孙一棒
    - 哇好多人啊
  mcdds:
    1:
      name: 皇上驾到
      imgUrl: https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062025304.png
    2:
      name: 龙颜大悦
      imgUrl: https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062025306.png
    3:
      name: 筋斗云
      imgUrl: https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062025308.png
    4:
      name: 望
      imgUrl: https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062025305.png
    5:
      name: 晕
      imgUrl: https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062025307.png
    6:
      name: 我
      imgUrl: https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062025303.png
    7:
      name: 打残
      imgUrl: https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062025309.png
    8:
      name: 红温
      imgUrl: https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062025302.png
```

<img src="https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062101701.png" alt="image-20240906210103571" style="zoom:67%;" />

# Spring Boot Dev Tools

```xml
 <!-- Spring Boot Dev Tools-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>
```

打开 IDEA 的自动构建项目选项

![image-20240906210618080](https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062106190.png)

```java
@RestController
@RequestMapping("/api/tests")
public class TestController {

    @PostMapping
    public String sayHello(@RequestParam(name = "name") String name) {
        return "Hello " + name;
    }
}
```

![image-20240906211118118](https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062111248.png)

仅需通过构建即可自动重启项目

![image-20240906211136346](https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062111496.png)

![image-20240906211145223](https://mcdd-dev-1311841992.cos.ap-beijing.myqcloud.com/assets/202409062111370.png)
