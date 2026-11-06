{
  description = "Minimal Java 17 project";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-24.11";
  };

  outputs = { self, nixpkgs }:
    let
      supportedSystems = [ "x86_64-linux" "aarch64-linux" ];
      forAllSystems = nixpkgs.lib.genAttrs supportedSystems;
    in
    {
      packages = forAllSystems (system:
        let
          pkgs = nixpkgs.legacyPackages.${system};
        in
        {
          default = pkgs.stdenv.mkDerivation {
            pname = "javabasics";
            version = "0.1.0";
            src = pkgs.lib.cleanSourceWith {
              src = ./.;
              filter = path: type:
                let name = baseNameOf path;
                in !(name == "result" || name == "build" || name == ".git");
            };

            nativeBuildInputs = [ pkgs.jdk17 ];

            buildPhase = ''
              runHook preBuild
              mkdir -p build/classes
              find src/main/java -name '*.java' -print0 \
                | xargs -0 javac -encoding UTF-8 --release 17 -d build/classes
              jar --create --file build/javabasics.jar -C build/classes .
              runHook postBuild
            '';

            installPhase = ''
              runHook preInstall
              mkdir -p $out/bin $out/share/java
              cp build/javabasics.jar $out/share/java/
              for uppgift in uppgift1 uppgift2 uppgift3; do
                cat > $out/bin/$uppgift <<EOF
              #!${pkgs.runtimeShell}
              exec ${pkgs.jdk17}/bin/java -cp $out/share/java/javabasics.jar $uppgift.Main "\$@"
              EOF
                chmod +x $out/bin/$uppgift
              done
              runHook postInstall
            '';
          };
        });

      apps = forAllSystems (system:
        let
          makeApp = uppgift: {
            type = "app";
            program = "${self.packages.${system}.default}/bin/${uppgift}";
          };
        in
        {
          default = makeApp "uppgift1";
          uppgift1 = makeApp "uppgift1";
          uppgift2 = makeApp "uppgift2";
          uppgift3 = makeApp "uppgift3";
        });

      devShells = forAllSystems (system:
        let
          pkgs = nixpkgs.legacyPackages.${system};
        in
        {
          default = pkgs.mkShell {
            packages = [ pkgs.jdk17 ];
          };
        });
    };
}
