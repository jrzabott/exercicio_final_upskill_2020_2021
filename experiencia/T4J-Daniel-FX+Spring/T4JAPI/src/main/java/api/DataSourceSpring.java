package api;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceSpring {

    private static String dataSourceURL = "jdbc:oracle:thin:UPSKILL_BD_Turma2_03/qwerty123@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl";
    private static DataSource ds;

    @Bean
    public static DataSource getDataSource() {
        if (ds == null) {
            DataSourceBuilder dsb = DataSourceBuilder.create();
            dsb.url(dataSourceURL);
            ds = dsb.build();
        }
        return ds;
    }
}
