# Ancient Greek Analyzer for eXistDB/Lucene
This is two classes I created to normalize Ancient Greek words in Lucene indexes in eXistDB 2.2 while working with the [CGRN](http://cgrn.ulg.ac.be) project team. The analyzer strip Ancient Greek diacritics and convert all characters to their lowercase equivalent. We tried to use the ICUFoldingFilter but some of the normalization was not satisfactory. For example, the « ῴ » character was normalized as the « ωι » string.

The analyzer class must be placed in the `/extensions/indexes/lucene/src/org/exist/indexing/lucene/analyzers` folder while the filter class must be placed in the `/extensions/indexes/lucene/src/org/exist/indexing/lucene/filters` folder.

One can then, after rebuilding eXistDB, refer to the analyzer class in the collection configuration file like this :
`<analyzer id="aga" class="org.exist.indexing.lucene.analyzers.AncientGreekAnalyzer"/>`
