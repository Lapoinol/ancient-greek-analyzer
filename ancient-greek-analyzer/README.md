# Ancient Greek Analyzer for eXistDB/Lucene
This is two classes I created to normalize Ancient Greek words in Lucene indexes in eXistDB 2.2. The Lucene Analyzer class must be placed in the `/extensions/indexes/lucene/src/org/exist/indexing/lucene/analyzers` folder while the filter class can be placed in the `/extensions/indexes/lucene/src/org/exist/indexing/lucene/filters` folder.

One can then, after rebuilding ExistDB, refer to this class in the collection configuration file like this :
`<analyzer id="aga" class="org.exist.indexing.lucene.analyzers.AncientGreekAnalyzer"/>`
