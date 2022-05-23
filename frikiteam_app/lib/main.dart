import 'package:flutter/material.dart';
import 'package:frikiteam_app/ui/login_page.dart';

void main() => runApp(FindEventApp());

//material app
class FindEventApp extends StatelessWidget {
  const FindEventApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "FrikiTeam App",
      debugShowCheckedModeBanner: false,
      theme: ThemeData.light(),
      home: LoginPage(),
    ) ;
  }
}