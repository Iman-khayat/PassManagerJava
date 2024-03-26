package main.java.com.example.PasswordManager;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, WebMvcAutoConfiguration.class }) // Exclude web dependencies
public class Main implements ApplicationListener<ContextRefreshedEvent> {

  private AddressView addressView;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    addressView = event.getApplicationContext().getBean(AddressView.class); // Get AddressView bean
    addressView.setVisible(true); // Make the window visible
  }

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
