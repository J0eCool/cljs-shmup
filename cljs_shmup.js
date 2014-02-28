goog.addDependency("base.js", ['goog'], []);
goog.addDependency("../cljs/core.js", ['cljs.core'], ['goog.string', 'goog.array', 'goog.object', 'goog.string.StringBuffer']);
goog.addDependency("../engine/vec2.js", ['engine.vec2'], ['cljs.core']);
goog.addDependency("../engine/sprite.js", ['engine.sprite'], ['cljs.core']);
goog.addDependency("../cljs_shmup/util.js", ['cljs_shmup.util'], ['cljs.core']);
goog.addDependency("../cljs_shmup/core.js", ['cljs_shmup.core'], ['engine.vec2', 'engine.sprite', 'cljs.core', 'cljs_shmup.util']);