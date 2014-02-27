goog.addDependency("base.js", ['goog'], []);
goog.addDependency("../cljs/core.js", ['cljs.core'], ['goog.string', 'goog.array', 'goog.object', 'goog.string.StringBuffer']);
goog.addDependency("../cljs_shmup/vec2.js", ['cljs_shmup.vec2'], ['cljs.core']);
goog.addDependency("../cljs_shmup/util.js", ['cljs_shmup.util'], ['cljs.core']);
goog.addDependency("../cljs_shmup/core.js", ['cljs_shmup.core'], ['cljs.core', 'cljs_shmup.vec2', 'cljs_shmup.util']);