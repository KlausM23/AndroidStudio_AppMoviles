import 'package:app_stateless_ful/stateful_page.dart';
import 'package:app_stateless_ful/stateless_page.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "State App",
      debugShowCheckedModeBanner: false,
      theme: ThemeData.light(),
      //home: StatelessApp(),
      home: const StatefulApp(),
    ) ;
  }
}