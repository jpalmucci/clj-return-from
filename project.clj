(defproject clj-return-from "1.0.1-SNAPSHOT"
  :description "Emulate common lisps return-from for clojure"
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :java-source-path "src/java"
  :dependencies [[org.clojure/tools.macro "0.1.2-SNAPSHOT"]]
  :dev-dependencies [[lein-javac "1.2.1-SNAPSHOT"]
                     [lein-multi "1.1.0-SNAPSHOT"]]
  :multi-deps {"1.3" [[org.clojure/clojure "1.3.0-beta3"]
                      [org.clojure/tools.macro "0.1.2-SNAPSHOT"]]
               "1.2" [[org.clojure/clojure "1.2.1"]
                      [org.clojure/tools.macro "0.1.2-SNAPSHOT"]]}
  )


