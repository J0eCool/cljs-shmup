(ns engine.entity
  (:require [engine.component :as component]))

(defprotocol EntProtocol
  (init [this])
  (update [this dT]))

(defrecord Entity [componentList]
  EntProtocol
  (init [this]
        )
  (update [this dT]))
