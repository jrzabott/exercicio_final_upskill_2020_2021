/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4j.app.repo;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author user
 */
@Configuration
public class DataSourceSpring {

    private static String dataSourceURL = "jdbc:oracle:thin:UPSKILL_BD_Turma2_12/Qwerty123@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl";
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
