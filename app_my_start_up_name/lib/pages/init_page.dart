import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

class Init extends StatefulWidget {
  const Init({Key? key}) : super(key: key);

  @override
  State<Init> createState() => _InitState();
}

class _InitState extends State<Init> {
  //WordPair wordPair = WordPair.random();

  @override
  Widget build(BuildContext context) {
    //wordPair = WordPair.random();
    return RandomWord();
  }
}

class RandomWord extends StatefulWidget {
  const RandomWord({Key? key}) : super(key: key);

  @override
  State<RandomWord> createState() => _RandomWordState();
}

class _RandomWordState extends State<RandomWord> {
  WordPair wordPair = WordPair.random();
  final List<WordPair> suggestions = <WordPair>[];
  final TextStyle biggerFont = TextStyle(fontSize: 16);

  @override
  Widget build(BuildContext context) {
    //final wordPair = WordPair.random(); //otra forma
    wordPair = WordPair.random();
    //return Text(wordPair.asPascalCase);
    return Scaffold(
      appBar: AppBar(
        title: Text("Name StartUp Gen"),
      ),
      body: buildSuggestions(),
    );
  }

  Widget buildSuggestions(){
    return ListView.builder(
        padding: EdgeInsets.all(10),
        itemBuilder: (BuildContext context, int i){
          if(i.isOdd){
            return Divider(
              color: Colors.red,
              thickness: 3, //tamaño de la raya que divivde cada elemento
            );
          }
          final int index = i ~/2;

          if(index >= suggestions.length){
            suggestions.addAll(generateWordPairs().take(10));
          }

          return buildRow(suggestions[index]);
        }
    );
  }

  Widget buildRow(WordPair pair){
    return ListTile(
      title: Text(
        pair.asPascalCase,
        style: biggerFont,
      ),
    );
  }
}
