import 'package:app_my_start_up_name/pages/init_page.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  //const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: "Start Up Name App",
      debugShowCheckedModeBanner: false,
      home: Init(),
    );
  }
}


