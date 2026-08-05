# Changelog

All notable changes to Mountain World follow this file. Versions before 1.0.0
were development-only and not released.

## [1.1.0] — 2026-08-05

Requires Isekai API 2.x. No world-generation change: terrain, biomes, ores,
structures and surface blocks are identical to 1.0.0.

### Changed
- `data/minecraft/worldgen/noise_settings/overworld.json` states the surface
  as Isekai's `isekai_api:vanilla_overworld_surface` delegate instead of an
  expanded copy of the vanilla surface-rule tree — 2541 → 389 lines. The
  delegate reconstructs the same vanilla overworld surface at runtime, so the
  emitted blocks are unchanged. `aquifers_enabled` and `ore_veins_enabled`
  stay `true`, so no router axis is zeroed.
- Worldshape and biome-source `"type"` ids use the canonical `isekai_api:`
  prefix (the bare `isekai:` prefix is deprecated in Isekai API 2.x).
- The build resolves Isekai API from its raw-URL maven repo, so this repo
  builds without a sibling checkout.

## [1.0.0] — 2026-05-28

First public release. Datapack-only all-mountain overworld built on Isekai API.

### World transformation
- `data/minecraft/worldgen/noise_settings/overworld.json` — overlay using
  vanilla `amplified` preset (3× vertical scale; peaks Y 280+, chasms below 0).
- `data/mountain_world/neoforge/biome_modifier/apply_mountain.json` — Isekai
  `apply_worldshape` modifier:
  - `playable_range` Y=80..300, trapezoid distribution
  - `ore_strategy: linear` — vanilla ore Y bands stretch across the mountain
  - per-structure predicates:
    - `village_{plains,savanna,taiga,desert}` → valleys (Y 80..140 + solid_floor 4)
    - `village_snowy` → high glacier band (Y 200..280 + solid_floor 4)
    - `stronghold` → deepest chasms (Y &lt;= 30)
    - ocean / shipwreck / buried_treasure → never
  - 36 surface biomes in `applies_to`
  - sky color #79CCFD, fog color #AF00FF (cold high-altitude tint)
- `data/mountain_world/neoforge/structure_modifier/apply_mountain.json` —
  clears biome filters for ocean structures.

### Java surface
- Single `MountainWorld.java` `@Mod` entry. Smoke-tests Isekai facade only.

### Known limitations
- New worlds only — already-generated chunks keep prior terrain.
- Conflicts with any mod that overlays
  `data/minecraft/worldgen/noise_settings/overworld.json`.
