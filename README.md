# Mountain World

> The overworld becomes all mountain, all the time. Y 80..300 is playable, valleys cut down past Y 0 into chasms, peaks reach glacier biomes at Y 280+. Vertical traversal is the game.

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![NeoForge 1.21.1](https://img.shields.io/badge/NeoForge-1.21.1-orange.svg)](https://neoforged.net)
[![Depends on Isekai API](https://img.shields.io/badge/Depends-Isekai%20API-9333ea)](https://github.com/KURONAMI333/isekai-api)

---

## Concept

There is no plain, no flat coast, no horizontal expanse — only slope, valley, and peak. Vanilla ores, structures, and mobs are remapped via [Isekai API](https://github.com/KURONAMI333/isekai-api): villages sit in valleys, strongholds in the deepest chasms, glaciers cap the highest peaks.

Pairs naturally with bridge / rope / climbing / glider mods (YUNG's Bridges, Sophisticated Ropes, Iron Jetpacks, Create: Aeronautics).

## How it works

Mountain World ships **only datapack JSON**:

1. **`data/minecraft/worldgen/noise_settings/overworld.json`** — overlay using vanilla's `amplified` preset (which triples vertical scale via tuned `offset` / `factor` density functions). Terrain easily reaches Y=280+ and bottoms out below Y=0.
2. **`data/mountain_world/neoforge/biome_modifier/apply_mountain.json`** — Isekai `apply_worldshape`:
   - `playable_range` Y=80..300 with `trapezoid` distribution (centre-heavy)
   - `ore_strategy: linear` — every ore's Y band stretches across the mountain volume
   - Per-structure predicates: villages low in valleys (Y 80..140 + solid floor); snowy villages high in glacier band (Y 200..280); strongholds in deep chasms (Y &lt;= 30); ocean structures excluded entirely
3. **`data/mountain_world/neoforge/structure_modifier/apply_mountain.json`** — strips ocean structures (no oceans in mountain world) by clearing their biome filter.

No Mixins, no custom blocks, no custom mobs. Mountain shape comes from vanilla's `amplified` noise; Isekai handles the rule adaptation.

## How to play

1. Install [Isekai API](https://github.com/KURONAMI333/isekai-api) and Mountain World together.
2. Create a new world. Spawn somewhere on a mountainside around Y=120-180.
3. Climb peaks for glacier biomes. Descend chasms (Y &lt; 30) to find strongholds.

## Dependencies

- NeoForge 1.21.1
- [Isekai API 1.0.0+](https://github.com/KURONAMI333/isekai-api) (required, loaded automatically)

## Building from source

```bash
./gradlew build
```

Produces `build/libs/mountain_world-1.0.0.jar`.

## Compatibility

Because Mountain World **overlays** `data/minecraft/worldgen/noise_settings/overworld.json`, it conflicts with other mods that override the same file (Terralith, BYG, Sky World, etc.). Run one or the other.

## License

[MIT License](LICENSE) — modpack inclusion welcome, no credit required.

## Credits

- Author: KURONAMI
- Built on [Isekai API](https://github.com/KURONAMI333/isekai-api)
- Terrain shape comes from Minecraft's vanilla `amplified` worldgen preset.
