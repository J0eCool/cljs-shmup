goog.addDependency("base.js", ['goog'], []);
goog.addDependency("../cljs/core.js", ['cljs.core'], ['goog.string', 'goog.array', 'goog.object', 'goog.string.StringBuffer']);
goog.addDependency("../engine/vec2.js", ['engine.vec2'], ['cljs.core']);
goog.addDependency("../engine/component.js", ['engine.component'], ['cljs.core']);
goog.addDependency("../cljs_shmup/components/sprite.js", ['cljs_shmup.components.sprite'], ['cljs.core', 'engine.component']);
goog.addDependency("../cljs_shmup/components/transform.js", ['cljs_shmup.components.transform'], ['cljs.core', 'engine.component']);
goog.addDependency("../engine/entity.js", ['engine.entity'], ['cljs.core', 'engine.component']);
goog.addDependency("../cljs_shmup/util.js", ['cljs_shmup.util'], ['cljs.core']);
goog.addDependency("../cljs_shmup/core.js", ['cljs_shmup.core'], ['engine.vec2', 'cljs.core', 'cljs_shmup.util', 'cljs_shmup.components.transform', 'cljs_shmup.components.sprite', 'engine.component']);