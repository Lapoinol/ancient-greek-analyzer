package org.exist.indexing.lucene.filters;

/*
Created by Olivier Lapointe, based on the GreekLowerCaseFilter created by the team of Apache Lucene.
This filter was created for the CGRN project: http://cgrn.ulg.ac.be
*/

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import java.io.IOException;

/**
 * Normalizes token text to lower case, removes most if not all Greek diacritics,
 * and standardizes final sigma to sigma.
 */
public final class AncientGreekFilter extends TokenFilter {
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);

    /**
     * Create a GreekLowerCaseFilter that normalizes Ancient Greek token text.
     *
     * @param in TokenStream to filter
     */
    public AncientGreekFilter(TokenStream in) {
        super(in);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            char[] chArray = termAtt.buffer();
            int chLen = termAtt.length();
            for (int i = 0; i < chLen;) {
                i += Character.toChars(
                        lowerCase(Character.codePointAt(chArray, i, chLen)), chArray, i);
            }
            return true;
        } else {
            return false;
        }
    }

    private int lowerCase(int codepoint) {
        switch(codepoint) {
      /* There are two lowercase forms of sigma:
       *   U+03C2: small final sigma (end of word)
       *   U+03C3: small sigma (otherwise)
       *
       * Standardize both to U+03C3
       */
            case '\u03C2': /* small final sigma */
                return '\u03C3'; /* small sigma */

      /* Some greek characters contain diacritics.
       * This filter removes these, converting to the lowercase base form.
       */
            //Alpha
            case '\u0386':
            case '\u0391':
            case '\u1f71':
            case '\u1FBA':
            case '\u1F08':
            case '\u1F0c':
            case '\u1F0a':
            case '\u1F0e':
            case '\u1F09':
            case '\u1F0d':
            case '\u1F0b':
            case '\u1F0f':
            case '\u1Fb9':
            case '\u1FB8':
            case '\u03ac':
            case '\u1F70':
            case '\u1FB6':
            case '\u1F00':
            case '\u1F04':
            case '\u1F02':
            case '\u1F06':
            case '\u1F01':
            case '\u1F05':
            case '\u1F03':
            case '\u1F07':
            case '\u1FB1':
            case '\u1FB0':
            case '\u1f88':
            case '\u1f8c':
            case '\u1f8a':
            case '\u1f8e':
            case '\u1f89':
            case '\u1f8d':
            case '\u1f8b':
            case '\u1fb2':
            case '\u1fb3':
            case '\u1fb4':
            case '\u1fb7':
            case '\u1f80':
            case '\u1f81':
            case '\u1f82':
            case '\u1f83':
            case '\u1f84':
            case '\u1f85':
            case '\u1f86':
                return '\u03B1';

            //Epsilon
            case '\u0388':
            case '\u1fc8':
            case '\u1f18':
            case '\u1f1c':
            case '\u1f1a':
            case '\u1f19':
            case '\u1f1d':
            case '\u1f1b':
            case '\u03AD':
            case '\u1f72':
            case '\u1f10':
            case '\u1f14':
            case '\u1f12':
            case '\u1f11':
            case '\u1f15':
            case '\u1f13':
            case '\u1f73':
                return '\u03b5';

            //Eta
            case '\u0389':
            case '\u1fca':
            case '\u1f28':
            case '\u1f2a':
            case '\u1f2c':
            case '\u1f2e':
            case '\u1f29':
            case '\u1f2d':
            case '\u1f2b':
            case '\u1f2f':
            case '\u03ae':
            case '\u1f74':
            case '\u1fc6':
            case '\u1f20':
            case '\u1f24':
            case '\u1f22':
            case '\u1f26':
            case '\u1f21':
            case '\u1f25':
            case '\u1f23':
            case '\u1f27':
            case '\u1f75':
            case '\u1f98':
            case '\u1f9c':
            case '\u1f9a':
            case '\u1f9e':
            case '\u1f99':
            case '\u1f9d':
            case '\u1f9b':
            case '\u1f9f':
            case '\u1fc4':
            case '\u1fc2':
            case '\u1fc7':
            case '\u1f90':
            case '\u1f94':
            case '\u1f92':
            case '\u1f96':
            case '\u1f91':
            case '\u1f95':
            case '\u1f93':
            case '\u1f97':
            case '\u1fc3':
                return '\u03B7';

            //Iota
            case '\u038A':
            case '\u03AA':
            case '\u03AF':
            case '\u03CA':
            case '\u0390':
            case '\u1fda':
            case '\u1f38':
            case '\u1f3c':
            case '\u1f3a':
            case '\u1f3e':
            case '\u1f39':
            case '\u1f3d':
            case '\u1f3b':
            case '\u1f3f':
            case '\u1fd9':
            case '\u1fd8':
            case '\u1f76':
            case '\u1fd6':
            case '\u1f30':
            case '\u1f34':
            case '\u1f32':
            case '\u1f36':
            case '\u1f31':
            case '\u1f35':
            case '\u1f33':
            case '\u1f37':
            case '\u1fd2':
            case '\u1fd7':
            case '\u1fd1':
            case '\u1fd0':
            case '\u1f77':
            case '\u1fd3':
                return '\u03B9';

            //Upsilon
            case '\u038E':
            case '\u03AB':
            case '\u03CD':
            case '\u03CB':
            case '\u03B0':
            case '\u1fea':
            case '\u1f59':
            case '\u1f5d':
            case '\u1f5b':
            case '\u1f5f':
            case '\u1fe9':
            case '\u1fe8':
            case '\u1f7a':
            case '\u1fe6':
            case '\u1f50':
            case '\u1f54':
            case '\u1f52':
            case '\u1f56':
            case '\u1f51':
            case '\u1f55':
            case '\u1f53':
            case '\u1f57':
            case '\u1fe2':
            case '\u1fe7':
            case '\u1fe1':
            case '\u1fe0':
            case '\u1f7b':
                return '\u03C5';

            //Omicron
            case '\u038C':
            case '\u03CC':
            case '\u1f48':
            case '\u1ff8':
            case '\u1f4c':
            case '\u1f4a':
            case '\u1f49':
            case '\u1f4d':
            case '\u1f4b':
            case '\u1f78':
            case '\u1f40':
            case '\u1f44':
            case '\u1f42':
            case '\u1f41':
            case '\u1f45':
            case '\u1f43':
            case '\u1f79':
                return '\u03BF';

            // Omega
            case '\u038f':
            case '\u1ffa':
            case '\u1f68':
            case '\u1fa8':
            case '\u1f6c':
            case '\u1fac':
            case '\u1f6a':
            case '\u1faa':
            case '\u1fae':
            case '\u1f69':
            case '\u1fa9':
            case '\u1f6d':
            case '\u1fad':
            case '\u1fab':
            case '\u1ff4':
            case '\u1f6f':
            case '\u1faf':
            case '\u03ce':
            case '\u1f7c':
            case '\u1ff6':
            case '\u1f60':
            case '\u1f64':
            case '\u1f62':
            case '\u1f66':
            case '\u1f61':
            case '\u1f65':
            case '\u1f63':
            case '\u1f67':
            case '\u1ff2':
            case '\u1ff7':
            case '\u1fa0':
            case '\u1fa1':
            case '\u1fa2':
            case '\u1fa3':
            case '\u1fa4':
            case '\u1fa5':
            case '\u1fa6':
            case '\u1fa7':
            case '\u1f6b':
            case '\u1ff3':
            case '\u1f7d':

                return '\u03c9';

            //Rho
            case '\u1fec' :
            case '\u1fe4' :
            case '\u1fe5' :
                return '\u03c1';

            // Esprits et accents
            case '\u1fcd' :
            case '\u1fbd' :
            case '\u1fbf' :
            case '\u1fce' :
            case '\u1fdd' :
            case '\u1fde' :
            case '\u1fdf' :
            case '\u1fed' :
            case '\u1fee' :
            case '\u1fef' :
            case '\u1ffd' :
            case '\u1ffe' :
            //Accents pour les epsilons et les omicrons
            case '\u0311' :
            case '\u0304' :
                return '\u0000';
      /* The previous implementation did the conversion below.
       * Only implemented for backwards compatibility with old indexes.
       */

            case '\u03A2': /* reserved */
                return '\u03C2'; /* small final sigma */

            default:
                return Character.toLowerCase(codepoint);
        }
    }
}
