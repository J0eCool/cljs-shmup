goog.addDependency("base.js", ['goog'], []);
goog.addDependency("../cljs/core.js", ['cljs.core'], ['goog.string', 'goog.array', 'goog.object', 'goog.string.StringBuffer']);
goog.addDependency("../game/util.js", ['game.util'], ['cljs.core']);
goog.addDependency("../engine/component.js", ['engine.component'], ['cljs.core']);
goog.addDependency("../game/components/sprite.js", ['game.components.sprite'], ['cljs.core', 'engine.component']);
goog.addDependency("../engine/vec2.js", ['engine.vec2'], ['cljs.core']);
goog.addDependency("../engine/entity.js", ['engine.entity'], ['cljs.core', 'engine.component']);
goog.addDependency("../game/components/transform.js", ['game.components.transform'], ['cljs.core', 'engine.component']);
goog.addDependency("../game/core.js", ['game.core'], ['game.components.sprite', 'engine.vec2', 'cljs.core', 'game.util', 'game.components.transform', 'engine.component']);