package com.quick.hbase;

import com.quick.hbase.bean.Annonce;
import com.quick.hbase.config.HBaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HbaseApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(HbaseApplication.class);
	}

	@Autowired
	HBaseClient hBaseClient;


	@Override
	public void run(String... args) throws Exception {
		hBaseClient.createTable(Annonce.class);
	}
}
